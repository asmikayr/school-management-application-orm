package com.cydeo.controller;

import com.cydeo.entity.Student;
import com.cydeo.enums.State;
import com.cydeo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("student",new Student());

        model.addAttribute("states", State.values());
        model.addAttribute("students", studentService.listAllStudents());

        return "/student/student-create";
    }

//    @PostMapping("/create")
//    public String insertUser(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()){
//
//            model.addAttribute("states", State.values());
//
//            return "/student/student-create";
//        }
//
//        studentService.save(student);
//
//        return "redirect:/student/create";
//    }
//
//    @GetMapping("/assign/{email}")
//    public String assignStudent(@PathVariable("email") String email, Model model){
//        Student student = studentService.findById(email);
//        model.addAttribute("student", student);
//
//        return "/student/student-courses";
//    }
//
//    @GetMapping("/delete/{email}")
//    public String deleteStudent(@PathVariable("email") String username){
//
//        studentService.deleteById(username);
//
//        return "redirect:/student/create";
//    }
//    @GetMapping("/update/{email}")
//    public String updateStudent(@PathVariable String email, Model model) {
//        model.addAttribute("student",studentService.findById(email));
//        model.addAttribute("states", State.values());
//
//        return "/student/student-update";
//    }
//
//    @PostMapping("/update")
//    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
//
//        if(bindingResult.hasErrors()){
//            model.addAttribute("states", State.values());
//            return "/student/student-update";
//        }
//        studentService.update(student);
//
//        return "redirect:/student/create";
//
//    }
//
//    @GetMapping("/enroll/{email}/{courseId}")
//    public String enrollStudent(@PathVariable String email, @PathVariable Long courseId){
//        studentService.enrollStudent(email, courseId);
//        return "redirect:/student/assign/{email}";
//    }
//
//    @GetMapping("/drop/{email}/{courseId}")
//    public String dropStudent(@PathVariable String email, @PathVariable Long courseId){
//        studentService.dropStudent(email, courseId);
//        return "redirect:/student/assign/{email}";
//    }
//
//    @ModelAttribute
//    public void defineGeneralModels(Model model) {
//        model.addAttribute("pageTitle", "Student || Events");
//    }
}
