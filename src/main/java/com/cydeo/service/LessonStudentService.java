package com.cydeo.service;


import com.cydeo.dto.LessonStudentDTO;
import java.util.List;

public interface LessonStudentService {

    List<LessonStudentDTO> findStudentsByInstructorId(Long id);

    LessonStudentDTO findById(Long id);

}