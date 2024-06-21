package com.cydeo.service.impl;

import com.cydeo.dto.CourseStudentDTO;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CourseStudentRepository;
import com.cydeo.service.CourseStudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    private final CourseStudentRepository courseStudentRepository;
    private final MapperUtil mapperUtil;

    public CourseStudentServiceImpl(CourseStudentRepository courseStudentRepository, MapperUtil mapperUtil) {
        this.courseStudentRepository = courseStudentRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<CourseStudentDTO> findAllByCourseId(Long courseId) {
        return courseStudentRepository.findAllByCourseId(courseId).stream()
                .map(courseStudent -> mapperUtil.convert(courseStudent, CourseStudentDTO.class))
                .collect(Collectors.toList());
    }
}
