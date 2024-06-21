package com.cydeo.service.impl;

import com.cydeo.dto.LessonDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Lesson;
import com.cydeo.entity.User;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.LessonRepository;
import com.cydeo.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    public List<LessonDTO> listAllByInstructor(UserDTO user) {
        List<Lesson> lessonList = lessonRepository.findAllByInstructorAndIsDeleted(mapperUtil.convert(user, User.class), false);
        return lessonList.stream().map(lesson -> mapperUtil.convert(lesson, LessonDTO.class)).collect(Collectors.toList());
    }

    @Override
    public LessonDTO findById(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(()->new NoSuchElementException("Lesson could not be found"));
        return mapperUtil.convert(lesson, LessonDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Lesson> foundLesson = lessonRepository.findById(id);
        if (foundLesson.isPresent()){
            foundLesson.get().setIsDeleted(true);
            lessonRepository.save(foundLesson.get());
        }
    }

    @Override
    public List<LessonDTO> findLessonsByCourseId(Long id) {
        return lessonRepository.findAllByCourseIdAndIsDeleted(id,false).stream()
                .map(lesson -> mapperUtil.convert(lesson,LessonDTO.class))
                .collect(Collectors.toList());
    }

}
