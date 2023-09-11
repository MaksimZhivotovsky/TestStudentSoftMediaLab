package com.example.service;

import com.example.model.Grade;

import java.util.List;

public interface GradeService {
    Grade save(Grade grade);
    List<Grade> findAll();
    Grade findById(Long gradeId);

}
