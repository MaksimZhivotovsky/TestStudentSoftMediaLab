package com.example.service.impl;

import com.example.exeptions.StudentNotFoundException;

import lombok.AllArgsConstructor;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

@AllArgsConstructor
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException("Client не найден с id : " + studentId)
        );
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(Long studentId, Student student) {
        Student dataStudent = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Client не найден с id : " + studentId)
        );
        if(dataStudent != null) {
            dataStudent.setFirstName(student.getFirstName());
            dataStudent.setLastName(student.getLastName());
            dataStudent.setGrades(student.getGrades());
            studentRepository.save(dataStudent);
        }
        return dataStudent;
    }

    @Override
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

