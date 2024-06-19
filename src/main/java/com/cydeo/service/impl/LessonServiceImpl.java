package com.cydeo.service.impl;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.LessonDTO;
import com.cydeo.entity.Course;
import com.cydeo.entity.Lesson;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.LessonRepository;
import com.cydeo.service.CourseService;
import com.cydeo.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final MapperUtil mapperUtil;
    private final CourseService courseService;

    public LessonServiceImpl(LessonRepository lessonRepository, MapperUtil mapperUtil, CourseService courseService) {
        this.lessonRepository = lessonRepository;
        this.mapperUtil = mapperUtil;
        this.courseService = courseService;
    }

    @Override
    public List<LessonDTO> findAllLessons() {
        return lessonRepository.findAllByIsDeleted(false)
                .stream()
                .map(lesson -> mapperUtil.convert(lesson, LessonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(LessonDTO lessonDTO) {
        lessonRepository.save(mapperUtil.convert(lessonDTO, Lesson.class));
    }

    @Override
    public List<LessonDTO> listAllLessonByCourse(Long id) {
        CourseDTO courseDTO = courseService.findById(id);
        Course courseEntity = mapperUtil.convert(courseDTO,Course.class);
        return lessonRepository.findAllByCourse(courseEntity).stream()
                .map(lesson -> mapperUtil.convert(lesson,LessonDTO.class))
                .collect(Collectors.toList());
    }


}