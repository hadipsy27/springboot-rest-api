package com.labs.springbootrestapi.controller;

import com.labs.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        final Student student = new Student(
                1, "John", "Doe"
        );
        return student;
    }
}
