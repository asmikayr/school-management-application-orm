package com.cydeo.mapper;

import com.cydeo.entity.Lesson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtil {

    private final ModelMapper mapper;

    public MapperUtil(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T convert(Object object, Class<T> convertedObj){
        return mapper.map(object, convertedObj);
    }

}
