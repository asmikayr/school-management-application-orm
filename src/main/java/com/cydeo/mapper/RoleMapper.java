package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;
import com.cydeo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public Role convertToEntity(RoleDTO dto) {
        return modelMapper.map(dto, Role.class);
    }

    public RoleDTO convertToDto(Role entity) {
        return modelMapper.map(entity, RoleDTO.class);
    }

}
