package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseStudentDTO {
    private Long id;
    private boolean isEnrolled;
    private CourseDTO course;
    private StudentDTO student;
}
