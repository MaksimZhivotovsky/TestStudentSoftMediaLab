package com.example.service.impl;

import com.example.exeptions.GradeNotFoundException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import com.example.model.Grade;
import com.example.repository.GradeRepository;
import com.example.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }


    @Override
    public Grade findById(Long gradeId) {
        return gradeRepository.findById(gradeId).orElseThrow(
                () -> new GradeNotFoundException("Такой оценки нет с id : " + gradeId )
        );
    }

    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }
}
