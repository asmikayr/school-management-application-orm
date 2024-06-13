package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoConverter implements Converter <String, RoleDTO> {

    RoleService roleService;
    public RoleDtoConverter(@Lazy RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public RoleDTO convert(String source) {
        if (source == null || source.equals(""))  return null;
        return roleService.findById(Long.parseLong(source));

    }
}