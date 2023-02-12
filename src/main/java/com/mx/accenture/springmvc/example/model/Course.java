package com.mx.accenture.springmvc.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCourse;

    @Column(name = "name_course")
    private String nameCourse;

    @Column(name = "type_course")
    private String typeCourse;

    @Column(name = "name_teacher")
    private String nameTeacher;

    @Column(name = "number_students")
    private int numberStudents;

    @Column(name = "number_lessons")
    private int numberLessons;


    public Course() {
    }



    public Course(String nameCourse, String typeCourse, String nameTeacher, int numberStudents, int numberLessons) {
        this.nameCourse = nameCourse;
        this.typeCourse = typeCourse;
        this.nameTeacher = nameTeacher;
        this.numberStudents = numberStudents;
        this.numberLessons = numberLessons;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(String typeCourse) {
        this.typeCourse = typeCourse;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    public int getNumberLessons() {
        return numberLessons;
    }

    public void setNumberLessons(int numberLessons) {
        this.numberLessons = numberLessons;
    }

}
