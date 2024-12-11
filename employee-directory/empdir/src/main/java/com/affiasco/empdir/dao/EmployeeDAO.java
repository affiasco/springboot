package com.affiasco.empdir.dao;

import com.affiasco.empdir.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee theEmployee);

    void deleteById(int employeeId);
}
