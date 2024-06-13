package com.cydeo.service.impl;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public List<CourseDTO> listAllCourses() {
        return null;
    }

    @Override
    public CourseDTO findById(Long id) {
        return null;
    }

    @Override
    public void save(CourseDTO dto) {

    }

    @Override
    public void update(CourseDTO dto) {

    }

    @Override
    public void delete(CourseDTO dto) {

    }
}
