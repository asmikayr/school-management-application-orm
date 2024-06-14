package com.cydeo.service.impl;

import com.cydeo.dto.CourseDTO;
import com.cydeo.entity.Course;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CourseRepository;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<CourseDTO> listAllCourse() {
        return courseRepository.findAllByIsDeleted(false).stream()
                .map(course -> mapperUtil.convert(course, new CourseDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(Long id) {
        Optional<Course> foundCourse = courseRepository.findById(id);
        return foundCourse.map(course -> mapperUtil.convert(course, new CourseDTO())).orElse(null);
    }

    @Override
    public void save(CourseDTO dto) {
        //retrieve all the students from db and assign course with false value

        courseRepository.save(mapperUtil.convert(dto, new Course()));
    }

    @Override
    public void update(CourseDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }
}
