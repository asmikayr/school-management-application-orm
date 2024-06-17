package com.cydeo.service;

import com.cydeo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> listAllStudents();
    StudentDTO getStudentById(Long id);
    void saveStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO);
    void deleteStudent(Long id);

}
