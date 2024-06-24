package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import com.cydeo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;

    public CourseController(@Lazy CourseService courseService, UserService userService) {
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

    @GetMapping("/update/{id}")
    public String editCourse(@PathVariable Long id, Model model){

        model.addAttribute("course",courseService.findById(id));
        model.addAttribute("managers",userService.listAllByRole("manager"));
        model.addAttribute("courses",courseService.listAllCourse());

        return "/course/course-update";
    }

    @PostMapping("/update/{id}")
    public String updateCourse(@Valid @ModelAttribute("course") CourseDTO course, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("managers",userService.listAllByRole("manager"));
            model.addAttribute("courses",courseService.listAllCourse());
        }
        courseService.update(course);
        return "redirect:/course/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id, RedirectAttributes redirectAttributes){

        if (courseService.checkAssignedCourseLessons(id)){
            courseService.delete(id);
            redirectAttributes.addFlashAttribute("success", "Successfully Deleted");
        }else {
            redirectAttributes.addFlashAttribute("error", "Course can not be deleted");
        }


        return "redirect:/course/create";
    }

}
