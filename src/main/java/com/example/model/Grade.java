package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"gradeId"})
@ToString(of = {"id", "text"})
@Table(name = "grades")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Сущность оценки")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long gradeId;

    @Schema(description = "Оценка")
    @Column(name = "id")
    private Long id;

    @Schema(description = "Текст оценки")
    @Column(name = "text")
    private String text;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "grades")
    @JsonIgnore
    private List<Student> students;

}