package com.affiasco.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // get the information in the "studentName" field from the request
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        // "message" is name, result is value
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    // studentName is HTML form name, bind it to theName
    public String processForm3(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();
        String result = "Hey there " + theName + " from v3";

        // "message" is name, result is value
        model.addAttribute("message", result);

        return "helloworld";
    }
}
