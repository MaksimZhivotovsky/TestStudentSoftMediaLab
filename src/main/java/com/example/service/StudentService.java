package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student findById(Long studentId);
    List<Student> findAll();
    Student update(Long studentId, Student student);
    void deleteById(Long studentId);
}
