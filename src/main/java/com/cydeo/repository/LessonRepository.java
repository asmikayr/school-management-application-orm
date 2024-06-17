package com.cydeo.repository;

import com.cydeo.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllByIsDeleted(Boolean deleted);

}
