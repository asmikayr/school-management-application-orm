package com.cydeo.mapper;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Address;
import com.cydeo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final ModelMapper modelMapper;

    public AddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public Address convertToEntity(AddressDTO dto) {
        return modelMapper.map(dto, Address.class);
    }

    public AddressDTO convertToDto(Address entity) {
        return modelMapper.map(entity, AddressDTO.class);
    }
}
