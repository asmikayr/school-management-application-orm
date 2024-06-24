package com.cydeo.service;

import com.cydeo.dto.CourseStudentDTO;

import java.util.List;

public interface CourseStudentService {
    List<CourseStudentDTO>listAllByStudentId(Long id);

    List<CourseStudentDTO> listAllByCourseId(Long id);

    void enroll(Long courseId, Long studentId);
}
