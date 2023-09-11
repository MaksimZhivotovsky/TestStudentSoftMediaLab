package com.example.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.example.model.Grade;
import com.example.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/API/V1/grades")
@Tag(name="Оценка", description="Взаимодействие с оценкой")
public class GradeRestControllerV1 {

    private final GradeService gradeService;

    @Operation(
            summary = "Получение списка оценок",
            description = "Позволяет показать список оценок"
    )
    @GetMapping
    public List<Grade> findAll() {
        return gradeService.findAll();
    }

    @Operation(
            summary = "Добавление новой оценки",
            description = "Позволяет добавить новую оценку в список"
    )
    @PostMapping
    public Grade save(@RequestBody Grade grade) {
        return gradeService.save(grade);
    }
}
