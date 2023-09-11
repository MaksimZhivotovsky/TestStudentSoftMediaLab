package com.example.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.example.model.Grade;
import com.example.model.Student;
import com.example.service.GradeService;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/API/V1/students")
@Tag(name="Студент", description="Взаимодействие со студентом")
public class StudentRestControllerV1 {

    private final StudentService studentService;
    private final GradeService gradeService;


    @Operation(
            summary = "Получение списка студентов",
            description = "Позволяет показать список студентов"
    )
    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @Operation(
            summary = "Получение студента по ID",
            description = "Позволяет получить студента по ID"
    )
    @GetMapping(value = "/{studentId}")
    public Student findById(@PathVariable("studentId") Long studentId) {
        return studentService.findById(studentId);
    }

    @Operation(
            summary = "Добавление студента",
            description = "Позволяет добавить студента"
    )
    @PostMapping
    public Student save(@Valid @RequestBody Student student) {
        return studentService.save(student);
    }

    @Operation(
            summary = "Добавление оценки студенту",
            description = "Позволяет добавить оценку студенту"
    )
    @PostMapping(value = "/{studentId}")
    public Student addGradeStudent(@PathVariable("studentId") Long studentId, @RequestBody Grade grade) {
        Student student = studentService.findById(studentId);
        Grade dataGrade = gradeService.findById(grade.getGradeId());
        if (student != null) {
            student.addGrade(dataGrade);
        }
        return studentService.update(studentId, student);
    }

    @Operation(
            summary = "Обновление студента",
            description = "Позволяет внести изменения в данные студента"
    )
    @PutMapping(value = "/{studentId}")
    public Student update(@PathVariable("studentId") Long studentId, @RequestBody Student student) {
        return studentService.update(studentId, student);
    }

    @Operation(
            summary = "Удаление студента по ID",
            description = "Позволяет удалить студента по ID"
    )
    @DeleteMapping(value = "/{studentId}")
    public void deleteById(@PathVariable("studentId") Long studentId) {
        studentService.deleteById(studentId);
    }
}