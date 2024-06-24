package com.cydeo.service.impl;

import com.cydeo.dto.CourseStudentDTO;
import com.cydeo.entity.Course;
import com.cydeo.entity.CourseStudent;
import com.cydeo.entity.Student;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.CourseStudentRepository;
import com.cydeo.repository.StudentRepository;
import com.cydeo.service.CourseService;
import com.cydeo.service.CourseStudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {
    private final CourseStudentRepository courseStudentRepository;
    private final CourseRepository courseRepository;
    private final MapperUtil mapper;
    private final StudentRepository studentRepository;

    public CourseStudentServiceImpl(CourseStudentRepository courseStudentRepository, MapperUtil mapper, StudentRepository studentRepository, CourseService courseService, CourseRepository courseRepository) {
        this.courseStudentRepository = courseStudentRepository;
        this.mapper = mapper;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseStudentDTO> listAllByStudentId(Long id) {
        return courseStudentRepository
                .findByStudentId(id).stream()
                .map(courseStudent -> mapper
                        .convert(courseStudent, CourseStudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseStudentDTO> listAllByCourseId(Long id) {
        return courseStudentRepository.findByCourseId(id)
                .stream()
                .map(courseStudent -> mapper.convert(courseStudent, CourseStudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void enroll(Long courseId, Long studentId) {
        CourseStudent courseStudent=courseStudentRepository.findByIdAndStudentId(courseId, studentId);
        courseStudent.setIsEnrolled(true);

    }
}
