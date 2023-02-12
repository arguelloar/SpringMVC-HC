package com.mx.accenture.springmvc.example.service;


import com.mx.accenture.springmvc.example.dto.StudentDTO;
import com.mx.accenture.springmvc.example.model.Course;
import com.mx.accenture.springmvc.example.model.Student;
import com.mx.accenture.springmvc.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//Implement the listAllStudents,
// findStudentById, addStudent, updateStudent,
// deleteStudent and listStudentCourses methods.
// Note. Update the existing database if needed.

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> listAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList
                .stream()
                .map(student -> dtoMapper(student))
                .collect(Collectors.toList());
    }

    public StudentDTO findStudentById(Long id){
        Optional<Student> studentOpt = studentRepository.findById(id);
        return dtoMapper(studentOpt.get());
    }

    public StudentDTO addStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setCourseList(studentDTO.getCourseList());
        studentRepository.save(student);
        return dtoMapper(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public StudentDTO updateStudent(Long id, String name, List<Course> courseList){
        Optional<Student> studentOpt = studentRepository.findById(id);
        Student student = studentOpt.get();
        if(name != null)student.setName(name);
        if(!courseList.isEmpty())student.setCourseList(courseList);
        studentRepository.save(student);
        return dtoMapper(student);
    }

    public List<Course> listStudentCourses(Long id){
        Optional<Student> studentOpt = studentRepository.findById(id);
        return studentOpt.get().getCourseList();
    }

    public StudentDTO dtoMapper(Student student){
        return new StudentDTO(student.getId(),student.getName(),student.getCourseList());
    }


}
