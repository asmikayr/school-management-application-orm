package com.cydeo.controller;

import com.cydeo.dto.InstructorAssessmentDTO;
import com.cydeo.dto.LessonStudentDTO;
import com.cydeo.service.InstructorAssessmentService;
import com.cydeo.service.LessonStudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    private final LessonStudentService lessonStudentService;
    private final InstructorAssessmentService instructorAssessmentService;

    public InstructorController(LessonStudentService lessonStudentService, InstructorAssessmentService instructorAssessmentService) {
        this.lessonStudentService = lessonStudentService;
        this.instructorAssessmentService = instructorAssessmentService;
    }


    @GetMapping("/students")
    public String instructorPage(Model model){

        model.addAttribute("studentLessons", lessonStudentService.findStudentsByInstructorId(4L));

        return "/instructor/general-assessment";
    }

    @GetMapping("/students/{lessonStudentId}")
    public String assessStudentPage(Model model, @PathVariable("lessonStudentId") Long lessonStudentId){
        LessonStudentDTO lessonStudent = lessonStudentService.findById(lessonStudentId);

        model.addAttribute("lessonStudent", lessonStudent);
        model.addAttribute("assessment", new InstructorAssessmentDTO());
        model.addAttribute("grades", instructorAssessmentService.findAllByLessonStudent(lessonStudent));

        return "/instructor/assess-student";
    }

    @PostMapping("/students/{lessonStudentId}")
    public String assessStudent(@Valid @ModelAttribute("assessment") InstructorAssessmentDTO assessment, BindingResult bindingResult, Model model, @PathVariable("lessonStudentId") Long lessonStudentId){

        LessonStudentDTO lessonStudent = lessonStudentService.findById(lessonStudentId);

        if (bindingResult.hasErrors()){
            model.addAttribute("lessonStudent", lessonStudent);
            return "/instructor/assess-student";
        }
      //  lessonStudentService.assessStudent(assessment, lessonStudentId);
        instructorAssessmentService.assessStudentById(assessment, lessonStudentId);
        return "redirect:/instructor/students";
    }
}
