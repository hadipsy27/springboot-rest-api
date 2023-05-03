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

    /* http://localhost:8080/students */
    @GetMapping("/students")
    public List<Student> getStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Okira", "Bukaran"));
        students.add(new Student(3, "Kertan", "Riara"));
        students.add(new Student(4, "Noiq", "Jiuan"));
        return students;
    }

    /* Springboot REST API with path variable
    * {id} -Uri Template Variable
    * http://localhost:8080/student/1/John/Doe
    * */
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    /* Springboot REST API with Request Param
    * http://localhost:8080/student/query?studentId=1&firstName=John&lastName=Doe
    */
    @GetMapping("/student/query")
    public Student studentRequestVariable(@RequestParam int studentId,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    /* Springboot REST API that handles HTTPS POST Request
    * @PostMapping and @RequestBody
    * http://localhost:8080/student/create
    * */
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    /* Springboot REST API that handles HTTPS PUT Request
    * Updating Existing Request
    * http://localhost:8080/student/1/update
    * */
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    /* Springboot REST API that handles HTTPS PUT Request
     * Delete Existing Request
     * http://localhost:8080/student/1/delete
     * */
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Delete Successfully";
    }
}
