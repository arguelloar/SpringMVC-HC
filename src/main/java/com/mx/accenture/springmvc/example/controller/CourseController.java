package com.mx.accenture.springmvc.example.controller;

import com.mx.accenture.springmvc.example.dto.CourseDTO;
import com.mx.accenture.springmvc.example.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public List<CourseDTO> listCourse(){
        return courseService.listCourses();
    }


    @PutMapping(path = "{id}")
    public CourseDTO updateCourse(@PathVariable Long id,
                                  @RequestParam(required = false) String nameCourse,
                                  @RequestParam(required = false) String typeCourse,
                                  @RequestParam(required = false) String nameTeacher,
                                  @RequestParam(required = false) int numberStudents,
                                  @RequestParam(required = false) int numberLessons){
        return courseService.updateCourse(id,nameCourse,typeCourse,nameTeacher,numberStudents,numberLessons);
    }

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO){
        return courseService.addCourse(courseDTO);
    }

    @GetMapping(path = "{id}")
    public  CourseDTO findCourse(@PathVariable Long id){
        return courseService.findById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
