package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findAllByIsDeleted(Boolean deleted);
    Course findByIdAndIsDeleted(Long id, Boolean deleted);
    List<Course> findAllByCourseManagerAndIsDeleted (User courseManager, Boolean deleted);

}
