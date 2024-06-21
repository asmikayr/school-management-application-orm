package com.cydeo.service;

import com.cydeo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> listAllStudents();
    StudentDTO findById(Long id);
    void saveStudent(StudentDTO studentDTO);
    void update(StudentDTO studentDTO);
    void assignedToStudent(Long id);
    void deleteStudent(Long id);

}
