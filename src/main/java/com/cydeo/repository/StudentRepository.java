package com.cydeo.repository;

import com.cydeo.entity.Lesson;
import com.cydeo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByIsDeleted(Boolean deleted);
}
