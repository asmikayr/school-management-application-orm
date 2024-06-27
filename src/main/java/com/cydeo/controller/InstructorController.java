package com.cydeo.controller;

import com.cydeo.service.LessonStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    private final LessonStudentService lessonStudentService;

    public InstructorController(LessonStudentService lessonStudentService) {
        this.lessonStudentService = lessonStudentService;
    }


    @GetMapping("/students")
    public String instructorPage(Model model){

        model.addAttribute("studentLessons", lessonStudentService.findStudentsByInstructorId(4L));

        return "/instructor/general-assessment";
    }

//    @GetMapping("/students/{email}/{id}")
//    public String assessStudentPage(Model model, @PathVariable String email, @PathVariable Long id){
//
//        model.addAttribute("instructorAssessment", new InstructorAssessment());
//        model.addAttribute("student", studentService.findById(email));
//        model.addAttribute("lesson", lessonService.findById(id));
//
//        return "instructor/assess-student";
//    }
//
//    @PostMapping("/students/{email}/{id}")
//    public String assessStudent(@Valid @ModelAttribute("instructorAssessment") InstructorAssessment instructorAssessment, BindingResult bindingResult, Model model, @PathVariable String email, @PathVariable Long id){
//        Student student = studentService.findById(email);
//        Lesson lesson = lessonService.findById(id);
//        if (bindingResult.hasErrors()){
//            model.addAttribute("student", student);
//            model.addAttribute("lesson", lesson);
//            return "/instructor/assess-student";
//        }
//        studentService.assessStudent(instructorAssessment, student.getEmail(), lesson);
//        return "redirect:/instructor/students";
//    }
}
