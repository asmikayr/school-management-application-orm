package com.cydeo.repository;

import com.cydeo.entity.CourseStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseStudentRepository extends JpaRepository<CourseStudent,Long>{
     List<CourseStudent> findByStudentId(Long id);
     List<CourseStudent> findByCourseId(Long id);
     CourseStudent findByIdAndStudentId(Long id, Long StudentId);
}
