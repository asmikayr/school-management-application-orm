package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import com.cydeo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;

    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createCourse(Model model){

        model.addAttribute("course",new CourseDTO());
        model.addAttribute("managers",userService.listAllByRole("manager"));
        model.addAttribute("courses",courseService.listAllCourse());

        return "/course/course-create";
    }

    @PostMapping("/create")
    public String insertCourse(@Valid @ModelAttribute("course") CourseDTO course, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("managers",userService.listAllByRole("manager"));
            model.addAttribute("courses",courseService.listAllCourse());
            return "/course/course-create";
        }
        courseService.save(course);
        return "redirect:/course/create";

    }
}
