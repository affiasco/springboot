package com.affiasco.springboot.mvccrud.dao;

import com.affiasco.springboot.mvccrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
