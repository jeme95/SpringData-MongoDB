package com.example.demo.student;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    Student findById(String id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    List<Student> findAll() {
        return repository.findAll();
    }

    List<Student> findByPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return repository.findAll(pageable).getContent();
    }

    List<Student> findAllSortingAge() {
        Sort sort = Sort.by(Sort.Direction.ASC, "age");
        return repository.findAll(sort);
    }

    List<Student> findByFirstName(String firstName) {
        return repository.findByFirstNameContainsIgnoreCase(firstName);
    }

    List<Student> findByFirstNameNativeQuery(String firstName) {
        return repository.getByName(firstName);
    }

    List<Student> findByFirstNameAndEmail(String firstName, String email) {
        return repository.findByFirstNameContainsIgnoreCaseAndEmailContainsIgnoreCase(firstName, email);
    }

    Student createStudent(Student student) {
        return repository.insert(student);
    }

    Student updateStudent(Student student) {
        return repository.save(student);
    }

    void deleteStudent(Student student) {
        repository.delete(student);
    }

    void deleteStudentById(String id) {
        repository.deleteById(id);
    }


    Student findByIdOrEmpty(String id) {
        return repository.findById("63243fbc72d0ff218e91c548").orElse(getEmptyStudent(id));
    }

    Student getEmptyStudent(String id) {
        return new Student("", "", "", "", "", "");
    }
}
