package com.cydeo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDTO {

    private Long id;

    @NotBlank(message = "Course name is required field")
    @Size(max = 40, min = 2, message = "Course name must be between 2 and 40 characters long")
    @Pattern(regexp = "[A-Za-z]\\w*(?:\\s[A-Za-z]\\w*)*", message = "Just use alphabetic characters with spaces")
    private String name;

    @NotBlank(message = "Course description is required field")
    @Size(max = 100, min = 5, message = "Course description must be between 5 and 100 characters long")
    private String description;

    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;

    @NotNull(message = "Select a course manager")
    private UserDTO courseManager;

}
