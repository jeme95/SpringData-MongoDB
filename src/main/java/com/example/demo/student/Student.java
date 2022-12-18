package com.example.demo.student;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Student {
    @Id
    String id;
    String title;
    String firstName;
    String lastName;
    int age;
    String email;
    String role;
    String password;

    public Student(String title, String firstName, String lastName, String email, String role, String password) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }
}
