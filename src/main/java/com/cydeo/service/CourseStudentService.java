package com.cydeo.service;

import com.cydeo.dto.CourseStudentDTO;

import java.util.List;

public interface CourseStudentService {

    List<CourseStudentDTO> findAllByCourseId(Long courseId);

}
