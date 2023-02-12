package com.mx.accenture.springmvc.example.dto;

import com.mx.accenture.springmvc.example.model.Course;

import java.util.List;

public class StudentDTO {

    public StudentDTO(Long id, String name, List<Course> courseList) {
        this.id = id;
        this.name = name;
        this.courseList = courseList;
    }

    private Long id;
    private String name;
    private List<Course> courseList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
