package com.affiasco.springboot.mvccrud.controller;

import com.affiasco.springboot.mvccrud.entity.Employee;
import com.affiasco.springboot.mvccrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees") // base for url requests
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> theEmployees = employeeService.findAll();
        // get employees from db

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
