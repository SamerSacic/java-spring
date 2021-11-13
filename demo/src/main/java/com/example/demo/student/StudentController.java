package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
/*
    Dependency Injection v1
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = new StudentService();
    }
*/

    // Dependency Injection v2 faster way
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @PostMapping
    public void addNewStudent(@RequestBody /* Mapping data from http request to the entity */ Student student) {
        studentService.addNew(student);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.update(studentId, name, email);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
    }
}
