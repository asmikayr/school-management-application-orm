package com.cydeo.controller;

import com.cydeo.dto.LessonDTO;
import com.cydeo.entity.Lesson;
import com.cydeo.service.CourseService;
import com.cydeo.service.LessonService;
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
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;
    private final CourseService courseService;
    private final UserService userService;

    public LessonController(LessonService lessonService, CourseService courseService, UserService userService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
        this.userService = userService;
    }


    @GetMapping("/create")
    public String createLesson(Model model){
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("courses", courseService.listAllCourse());
        model.addAttribute("instructors", userService.listAllByRole("Instructor"));
        model.addAttribute("lessons", lessonService.findAllLessons());

        return "/lesson/lesson-create";
    }

    @PostMapping("/create")
    public String insertLesson(@Valid @ModelAttribute("lesson") LessonDTO lessonDTO, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("courses", courseService.listAllCourse());
            model.addAttribute("instructors", userService.listAllByRole("Instructor"));
            model.addAttribute("lessons", lessonService.findAllLessons());
            return "/lesson/lesson-create";
        }
        lessonService.save(lessonDTO);
        return "redirect:/lesson/create";
    }

}
