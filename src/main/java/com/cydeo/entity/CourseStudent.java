package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CourseStudent extends BaseEntity{

    private Boolean isEnrolled;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

}
