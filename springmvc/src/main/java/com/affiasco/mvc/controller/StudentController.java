package com.affiasco.mvc.controller;

import com.affiasco.mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create new student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("languages", languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    // bind modelAttribute to param being passed in, so fills in the student object with the information
    public String processForm(@ModelAttribute("student") Student theStudent) {
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " " + theStudent.getCountry());
        return "student-confirmation";
    }
}
