package com.cydeo.mapper;

import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student convertToEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }

    public StudentDTO convertToDto(Student entity) {
        return modelMapper.map(entity, StudentDTO.class);
    }
}
