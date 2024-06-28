package com.cydeo.service;

import com.cydeo.dto.InstructorAssessmentDTO;
import com.cydeo.dto.LessonStudentDTO;

import java.util.List;


public interface InstructorAssessmentService {

    List<InstructorAssessmentDTO> findAllByLessonStudent(LessonStudentDTO dto);

    void assessStudentById(InstructorAssessmentDTO dto, Long lessonStudentId);
}
