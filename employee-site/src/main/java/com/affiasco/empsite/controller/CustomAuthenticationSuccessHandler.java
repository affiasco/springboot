package com.affiasco.empsite.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService;

    public CustomAuthenticationSuccessHandler(UserService theUserService) {
        userService = theUserService;
    }

    // The below method 1) gets user from db via userService 2) plcaes user in session 3) forward to homepage
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        System.out.println("In CustomAuthenticationSuccessHandler");

        String userName = authentication.getName();
        User theUser = userService.findByUsername(userName);

        // place user into session
        HttpSession session = request.getSession();
        session.setAttribute("user", theUser);

        // forward to homepage
        response.sendRedirect(request.getContextPath() + "/");
    }

}
