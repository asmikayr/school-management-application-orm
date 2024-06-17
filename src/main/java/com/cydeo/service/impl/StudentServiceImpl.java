package com.cydeo.service.impl;

import com.cydeo.dto.StudentDTO;
import com.cydeo.entity.Student;
import com.cydeo.mapper.StudentMapper;
import com.cydeo.repository.StudentRepository;
import com.cydeo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
//    private final ModelMapper modelMapper;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> listAllStudents() {

        List<Student> studentList = studentRepository.findAll(Sort.by("firstName"));
        return studentList.stream().map(studentMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentMapper.convertToDto(studentRepository.findById(id).get());
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {

        studentRepository.save(studentMapper.convertToEntity(studentDTO));

    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
