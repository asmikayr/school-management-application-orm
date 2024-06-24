package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "course_student")
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudent extends BaseEntity {
    private Boolean isEnrolled;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;
}
