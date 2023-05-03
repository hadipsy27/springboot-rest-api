package com.labs.springbootrestapi.controller;

import com.labs.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    /*
    Http Get Request
    http://localhost:8080/hello-world
    */

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

}
