package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonStudent extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    public Lesson lesson;
    @ManyToOne(fetch = FetchType.LAZY)
    public Student student;
}
