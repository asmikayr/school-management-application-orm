package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "assessments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorAssessment extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private LessonStudent lessonStudent;
    private LocalDate gradeDate;
    private Long grade;
    private String instructorImpressionOfStudent;
}
