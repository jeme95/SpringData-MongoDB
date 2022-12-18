package com.example.demo.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByFirstNameContainsIgnoreCase(String firstName);

    //    OR Operator analog
    List<Student> findByFirstNameContainsIgnoreCaseAndEmailContainsIgnoreCase(String firstName, String email);

    //    Starts with analog

    //    Native MongoDB Queries
    @Query("{\"firstName\" :  \"?0\" }")
    List<Student> getByName(String firstName);

}
