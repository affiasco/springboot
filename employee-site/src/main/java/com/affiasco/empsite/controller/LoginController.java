package com.affiasco.empsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // matches the spring security methods .login param
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
