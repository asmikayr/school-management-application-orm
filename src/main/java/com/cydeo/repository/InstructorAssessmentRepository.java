package com.cydeo.repository;

import com.cydeo.entity.InstructorAssessment;
import com.cydeo.entity.LessonStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorAssessmentRepository extends JpaRepository<InstructorAssessment, Long> {

    List<InstructorAssessment> findAllByLessonStudent(LessonStudent lessonStudent);

}
