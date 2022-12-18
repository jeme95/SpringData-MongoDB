package com.example.demo.student;

public class StudentNotFoundException extends RuntimeException {

    StudentNotFoundException(String id) {
        super("Could not find student " + id);
    }

}
