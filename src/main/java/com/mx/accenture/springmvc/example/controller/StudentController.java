package com.mx.accenture.springmvc.example.controller;

import com.mx.accenture.springmvc.example.dto.CourseDTO;
import com.mx.accenture.springmvc.example.dto.StudentDTO;
import com.mx.accenture.springmvc.example.model.Course;
import com.mx.accenture.springmvc.example.model.Student;
import com.mx.accenture.springmvc.example.repository.StudentRepository;
import com.mx.accenture.springmvc.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> listAllStudents(){
        return studentService.listAllStudents();
    }

    @GetMapping(path = "{id}")
    public StudentDTO findStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public StudentDTO updateCourse(@PathVariable Long id,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) List<Course> courseList){
        return studentService.updateStudent(id,name,courseList);
    }
}
