package com.cydeo.service;

import com.cydeo.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> listAllCourse();
    CourseDTO findById(Long id);
    void save(CourseDTO dto);
    void update(CourseDTO dto);
    void delete(Long id);

}
