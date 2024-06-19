package com.cydeo.service.impl;

import com.cydeo.dto.LessonDTO;
import com.cydeo.entity.Lesson;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.LessonRepository;
import com.cydeo.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final MapperUtil mapperUtil;

    public LessonServiceImpl(LessonRepository lessonRepository, MapperUtil mapperUtil) {
        this.lessonRepository = lessonRepository;
        this.mapperUtil = mapperUtil;
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
    public LessonDTO findById(Long id) {
        return mapperUtil.convert(lessonRepository.findById(id), LessonDTO.class);
    }


}
