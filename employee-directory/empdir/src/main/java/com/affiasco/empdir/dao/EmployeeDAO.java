package com.affiasco.empdir.dao;

import com.affiasco.empdir.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
