package com.cydeo.service;

import com.cydeo.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> listAllCourses();
    CourseDTO findById(Long id);
    void save(CourseDTO dto);
    void update(CourseDTO dto);
    void delete(CourseDTO dto);

}
