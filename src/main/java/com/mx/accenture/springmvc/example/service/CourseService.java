package com.mx.accenture.springmvc.example.service;

import com.mx.accenture.springmvc.example.dto.CourseDTO;
import com.mx.accenture.springmvc.example.model.Course;
import com.mx.accenture.springmvc.example.model.Student;
import com.mx.accenture.springmvc.example.repository.CourseRepository;
import com.mx.accenture.springmvc.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<CourseDTO> listCourses() {
        List<Course> cursos = courseRepository.findAll();

        return cursos.stream()
                .map(this::mapCourseToCourseDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(Long id) {
        Optional<Course> optCourse = courseRepository.findById(id);
        return mapCourseToCourseDTO(optCourse.get());
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        courseRepository.save(mapCourseDtoToCourse(courseDTO));
        return courseDTO;
    }

    public CourseDTO updateCourse(Long id,
                                  String nameCourse,
                                  String typeCourse,
                                  String nameTeacher,
                                  int numberStudents,
                                  int numberLessons) {
        Optional<Course> optCourse = courseRepository.findById(id);
        if (optCourse.isPresent()) {
            Course course = optCourse.get();
            if (nameCourse != null) course.setNameCourse(nameCourse);
            if (typeCourse != null) course.setTypeCourse(typeCourse);
            if (nameTeacher != null) course.setNameTeacher(nameTeacher);
            if (numberStudents != 0) course.setNumberStudents(numberStudents);
            if (numberLessons != 0) course.setNumberLessons(numberLessons);
            courseRepository.save(course);
            return mapCourseToCourseDTO(course);
        }
        return mapCourseToCourseDTO(optCourse.get());
    }

    public void deleteCourse(Long idCourse) {
        List<Student> all = studentRepository.findAll();
        all.forEach(student -> {
            List<Course> courseList = student.getCourseList();
            courseList.removeIf(course -> course.getIdCourse().equals(idCourse));
        });
        all.forEach(student -> studentRepository.save(student));
    }

    private CourseDTO mapCourseToCourseDTO(Course course) {
        return new CourseDTO(
                course.getIdCourse(),
                course.getNameCourse(),
                course.getTypeCourse(),
                course.getNameTeacher(),
                course.getNumberStudents(),
                course.getNumberLessons());
    }

    private Course mapCourseDtoToCourse(CourseDTO courseDTO) {
        return new Course(
                courseDTO.getNameCourse(),
                courseDTO.getTypeCourse(),
                courseDTO.getNameTeacher(),
                courseDTO.getNumberStudents(),
                courseDTO.getNumberLessons());
    }
}