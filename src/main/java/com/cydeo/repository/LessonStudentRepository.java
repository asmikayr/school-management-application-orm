package com.cydeo.repository;

import com.cydeo.entity.LessonStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonStudentRepository extends JpaRepository<LessonStudent, Long> {
}
