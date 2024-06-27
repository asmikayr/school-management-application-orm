package com.cydeo.repository;

import com.cydeo.entity.LessonStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonStudentRepository extends JpaRepository<LessonStudent, Long> {

    List<LessonStudent> findAllByLessonInstructorId(Long id);
}
