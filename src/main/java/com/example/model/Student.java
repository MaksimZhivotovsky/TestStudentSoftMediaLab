package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"studentId"})
@Getter
@Setter
@ToString(of = {"lastName", "firstName"})
@Table(name = "students")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Сущность студента")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @NotBlank
    @Schema(description = "Фамилия студента", example = "A-Я, A-Z, 0-9")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Schema(description = "Фамилия студента", example = "A-Я, A-Z, 0-9")
    @Column(name = "first_name")
    private String firstName;

    @Schema(description = "Дата рождения", example = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "student_grades",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "grade_id") })
    private List<Grade> grades;

    public void addGrade(Grade grade) {
        grades.add(grade);
    }
}
