package com.affiasco.empdir.dao;

import com.affiasco.empdir.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
