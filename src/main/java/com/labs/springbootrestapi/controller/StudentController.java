package com.labs.springbootrestapi.controller;

import com.labs.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        final Student student = new Student(
                1, "John", "Doe"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("custom-header", "John")
                .body(student);
    }


    /* http://localhost:8080/students */
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Okira", "Bukaran"));
        students.add(new Student(3, "Kertan", "Riara"));
        students.add(new Student(4, "Noiq", "Jiuan"));
        return ResponseEntity.ok(students);
    }

    /* Springboot REST API with path variable
     * {id} -Uri Template Variable
     * http://localhost:8080/students/1/John/Doe
     * */
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        final Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /* Springboot REST API with Request Param
     * http://localhost:8080/student/query?studentId=1&firstName=John&lastName=Doe
     */
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int studentId,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        final Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /* Springboot REST API that handles HTTPS POST Request
     * @PostMapping and @RequestBody
     * http://localhost:8080/student/create
     * */
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    /* Springboot REST API that handles HTTPS PUT Request
     * Updating Existing Request
     * http://localhost:8080/student/1/update
     * */
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    /* Springboot REST API that handles HTTPS PUT Request
     * Delete Existing Request
     * http://localhost:8080/student/1/delete
     * */
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Delete Successfully");
    }
}
