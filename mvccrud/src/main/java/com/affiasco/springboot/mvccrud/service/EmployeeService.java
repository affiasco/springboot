package com.affiasco.springboot.mvccrud.service;

import com.affiasco.springboot.mvccrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
