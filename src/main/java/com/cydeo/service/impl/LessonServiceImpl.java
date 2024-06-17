package com.cydeo.service.impl;

import com.cydeo.dto.LessonDTO;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.LessonRepository;
import com.cydeo.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(lesson -> mapperUtil.convert(lesson, new LessonDTO()))
                .collect(Collectors.toList());
    }
}
