package com.cydeo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtil {

    private final ModelMapper mapper;

    public MapperUtil(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T convert(Object object, T convertedObj){
        return mapper.map(object, (Type) convertedObj);
    }

}
