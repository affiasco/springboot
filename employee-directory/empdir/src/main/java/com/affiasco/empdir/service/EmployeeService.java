package com.affiasco.empdir.service;

import com.affiasco.empdir.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee theEmployee);

    void deleteById(int employeeId);
}

