package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/")
    List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/pagination")
    List<Student> findByPagination(@RequestParam int page, @RequestParam int size) {
        return studentService.findByPagination(page, size);
    }

    @GetMapping("/sorting")
    List<Student> findAllSortingAge() {
        return studentService.findAllSortingAge();
    }

    @GetMapping("/{id}")
    Student findById(@PathVariable String id) {
        return studentService.findById(id);
    }

    @GetMapping("/byName")
    List<Student> findByFirstName(@RequestParam String firstName) {
        return studentService.findByFirstName(firstName);
    }

    @GetMapping("/byNameNativeQuery")
    List<Student> findByFirstNameNativeQuery(@RequestParam String firstName) {
        return studentService.findByFirstNameNativeQuery(firstName);
    }

    @GetMapping("/byNameAndEmail")
    List<Student> findByFirstNameAndEmail(@RequestParam String firstName, @RequestParam String email) {
        return studentService.findByFirstNameAndEmail(firstName, email);
    }

    @PostMapping("/")
    Student createOne(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


    @PutMapping("/")
    Student updateOne(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/")
    void deleteOne(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable String id) {
        studentService.deleteStudentById(id);
    }


}
