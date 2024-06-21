package com.cydeo.service;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> listAllCourse();
    CourseDTO findById(Long id);
    void save(CourseDTO dto);
    void update(CourseDTO dto);
    void delete(Long id);
    List<CourseDTO> listAllCourseByCourseManager(UserDTO userDTO);
    boolean checkAssignedCourseLessons(Long courseId);

}
