package com.cydeo.controller;

import com.cydeo.dto.StudentDTO;
import com.cydeo.entity.Student;
import com.cydeo.enums.State;
import com.cydeo.service.CourseService;
import com.cydeo.service.CourseStudentService;
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
    private final CourseService courseService;
    private final CourseStudentService courseStudentService;


    public StudentController(StudentService studentService, CourseService courseService, CourseStudentService courseStudentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.courseStudentService = courseStudentService;
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
        model.addAttribute("studentCourses", courseStudentService.listAllByStudentId(id));
        return "/student/student-courses";
    }

//    @GetMapping ("/enroll/{courseId}/{studentId}")
//    public String enrollStudent(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId){
//        courseStudentService.enroll(courseId, studentId);
//        return "redirect:/student/assign/{studentId}";
//    }


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
