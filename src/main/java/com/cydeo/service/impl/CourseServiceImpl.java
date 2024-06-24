package com.cydeo.service.impl;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.CourseStudentDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Course;
import com.cydeo.entity.User;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.CourseStudentRepository;
import com.cydeo.service.CourseService;
import com.cydeo.service.CourseStudentService;
import com.cydeo.service.LessonService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;
    private final CourseStudentService courseStudentService;
    private final LessonService lessonService;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil, @Lazy CourseStudentService courseStudentService, LessonService lessonService) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
        this.courseStudentService = courseStudentService;
        this.lessonService = lessonService;
    }


    @Override
    public List<CourseDTO> listAllCourse() {
        return courseRepository.findAllByIsDeleted(false).stream()
                .map(course -> mapperUtil.convert(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(Long id) {
        Optional<Course> foundCourse = courseRepository.findById(id);
        return foundCourse.map(course -> mapperUtil.convert(course, CourseDTO.class)).orElse(null);
    }

    @Override
    public void save(CourseDTO dto) {
        courseRepository.save(mapperUtil.convert(dto, Course.class));
    }

    @Override
    public void update(CourseDTO dto) {
        Optional<Course> foundTask = courseRepository.findById(dto.getId());
        Course convertedDto = mapperUtil.convert(dto, Course.class);
        if (foundTask.isPresent()){
            convertedDto.setId(foundTask.get().getId());
            courseRepository.save(convertedDto);
        }
    }

    @Override
    public void delete(Long id) {
        if (checkAssignedCourseLessons(id)){
            courseStudentService.listAllByCourseId(id)
                    .forEach(courseStudentDTO -> {
                        courseStudentDTO.setCourse(new CourseDTO());
                        courseStudentDTO.setEnrolled(false);
                    });
            Course course = courseRepository.findById(id).get();
            course.setIsDeleted(true);
            courseRepository.save(course);
        }
    }

    @Override
    public List<CourseDTO> listAllCourseByCourseManager(UserDTO userDTO) {
        List<Course> courseList = courseRepository.findAllByCourseManagerAndIsDeleted(mapperUtil.convert(userDTO, User.class), false);
        return courseList.stream().map(course -> mapperUtil.convert(course, CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public boolean checkAssignedCourseLessons(Long courseId) {
        return lessonService.findLessonsByCourseId(courseId).isEmpty();
    }
}
