package com.cydeo.service;

import com.cydeo.dto.LessonDTO;

import java.util.List;

public interface LessonService {

    List<LessonDTO> findAllLessons();

    void save(LessonDTO lessonDTO);

    LessonDTO findById(Long id);
}
