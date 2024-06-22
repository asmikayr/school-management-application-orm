package com.cydeo.controller;

import com.cydeo.dto.StudentDTO;
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

    @PostMapping("/create")
    public String insertUser(@Valid @ModelAttribute("student") StudentDTO student, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){

            model.addAttribute("states", State.values());
            model.addAttribute("students", studentService.listAllStudents());

            return "/student/student-create";
        }

        studentService.saveStudent(student);

        return "redirect:/student/create";
    }

    @GetMapping("/assign/{id}")
    public String assignStudent(@PathVariable("id") Long id, Model model){
        StudentDTO student = studentService.findById(id);
        model.addAttribute("student", student);

        return "/student/student-courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){

        studentService.deleteStudent(id);

        return "redirect:/student/create";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student",studentService.findById(id));
        model.addAttribute("states", State.values());

        return "/student/student-update";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@Valid @ModelAttribute("student") StudentDTO student, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("states", State.values());
            return "/student/student-update";
        }
        studentService.update(student);

        return "redirect:/student/create";

    }

//    @GetMapping("/enroll/{email}/{courseId}")
//    public String enrollStudent(@PathVariable String email, @PathVariable Long courseId){
//        studentService.enrollStudent(email, courseId);
//        return "redirect:/student/assign/{email}";
//    }

//    @GetMapping("/drop/{email}/{courseId}")
//    public String dropStudent(@PathVariable String email, @PathVariable Long courseId){
//        studentService.dropStudent(email, courseId);
//        return "redirect:/student/assign/{email}";
//    }

    @ModelAttribute
    public void defineGeneralModels(Model model) {
        model.addAttribute("pageTitle", "Student || Events");
    }
}
