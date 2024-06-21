package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentDTO {

    private Long id;

    private Boolean isEnrolled;

    private CourseDTO course;

    private StudentDTO student;

}
