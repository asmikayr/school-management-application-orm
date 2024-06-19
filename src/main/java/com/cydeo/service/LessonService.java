package com.cydeo.service;

import com.cydeo.dto.LessonDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface LessonService {

    List<LessonDTO> findAllLessons();

    void save(LessonDTO lessonDTO);

    List<LessonDTO> listAllByInstructor(UserDTO user);
