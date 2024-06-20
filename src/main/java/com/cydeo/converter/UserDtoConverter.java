package com.cydeo.converter;

import com.cydeo.dto.UserDTO;
//import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import com.cydeo.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements Converter<String, UserDTO> {
    UserService userService;

    public UserDtoConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {

        if (source == null || source.equals("")) {
            return null;
        }

        return userService.findById(Long.parseLong(source));


    }

}
