package com.cydeo.dto;

import com.cydeo.entity.Course;
import com.cydeo.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LessonDTO {

    private Long id;

    @NotBlank(message = "Lesson name is a required field")
    @Size(max = 40, min = 2, message = "Lesson name must be between 2 and 40 characters long")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+[a-zA-Z]$", message = "Lesson name must use alphabetic characters with spaces")
    private String name;

    @NotBlank(message = "lesson description is a required field")
    @Size(max = 100, min = 5, message = "lesson Description must be between 5 and 100 characters long")
    private String description;

    @NotNull(message = "Select a course")
    private Course course;

    @NotNull(message = "Select an instructor")
    private User instructor;


}
