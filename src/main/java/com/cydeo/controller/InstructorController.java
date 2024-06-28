package com.cydeo.controller;

import com.cydeo.dto.InstructorAssessmentDTO;
import com.cydeo.service.InstructorAssessmentService;
import com.cydeo.service.LessonStudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructor/students")
public class InstructorController {

    private final LessonStudentService lessonStudentService;
    private final InstructorAssessmentService instructorAssessmentService;

    public InstructorController(LessonStudentService lessonStudentService, InstructorAssessmentService instructorAssessmentService) {
        this.lessonStudentService = lessonStudentService;
        this.instructorAssessmentService = instructorAssessmentService;
    }


    @GetMapping
    public String instructorPage(Model model){

        model.addAttribute("studentLessons", lessonStudentService.findStudentsByInstructorId(4L));

        return "/instructor/general-assessment";
    }

//    @GetMapping("/{lessonStudentId}")
//    public String assessStudentPage(Model model, @PathVariable("lessonStudentId") Long lessonStudentId){
//
//        model.addAttribute("assessment", new InstructorAssessmentDTO());
//        model.addAttribute("lessonStudent", lessonStudentService.findById(lessonStudentId));
//        model.addAttribute("grades", instructorAssessmentService.findGradesByLessonStudentId(lessonStudentId));
//
//        return "instructor/assess-student";
//    }
//
//    @PostMapping("/{lessonStudentId}")
//    public String assessStudent(@Valid @ModelAttribute("instructorAssessment") InstructorAssessmentDTO instructorAssessment, BindingResult bindingResult, Model model, @PathVariable("lessonStudentId") Long lessonStudentId){
//
//        if (bindingResult.hasErrors()){
//            model.addAttribute("lessonStudent", lessonStudentService.findById(lessonStudentId));
//            return "/instructor/assess-student";
//        }
//        lessonStudentService.assessStudent(instructorAssessment, lessonStudentId);
//        return "redirect:/instructor/students";
//    }
}
