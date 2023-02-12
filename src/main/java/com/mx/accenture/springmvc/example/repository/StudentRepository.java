package com.mx.accenture.springmvc.example.repository;


import com.mx.accenture.springmvc.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
