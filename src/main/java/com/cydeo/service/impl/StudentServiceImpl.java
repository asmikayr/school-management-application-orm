package com.cydeo.service.impl;

import com.cydeo.dto.StudentDTO;
import com.cydeo.entity.Student;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.StudentRepository;
import com.cydeo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final MapperUtil mapperUtil;

    public StudentServiceImpl(StudentRepository studentRepository,MapperUtil mapperUtil) {
        this.studentRepository = studentRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<StudentDTO> listAllStudents() {

        //List<Student> studentList = studentRepository.findAllByIsDeleted(false);
        //return studentList.stream().map(studentMapper::convertToDto).collect(Collectors.toList());

        return studentRepository.findAllByIsDeleted(false).stream().
                map(student -> mapperUtil.convert(student, StudentDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Long id) {

        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return mapperUtil.convert(student.get(), StudentDTO.class);
        }

        return null;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {

        studentRepository.save(mapperUtil.convert(studentDTO, Student.class));

    }

    @Override
    public void update(StudentDTO studentDTO) {


        Optional<Student> student = studentRepository.findById(studentDTO.getId());
        Student convertedStudent = mapperUtil.convert(studentDTO, Student.class);

        if (student.isPresent()) {
            studentRepository.save(convertedStudent);
        }
    }

    @Override
    public void assignedToStudent(Long id) {



    }

    @Override
    public void deleteStudent(Long id) {

    }
}
