package com.cydeo.controller;

import com.cydeo.entity.Lesson;
import com.cydeo.service.CourseService;
import com.cydeo.service.LessonService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("instructors", userService.listAllByRole("instructor"));
        model.addAttribute("lessons", lessonService.findAllLessons());

        return "/lesson/lesson-create";
    }
}