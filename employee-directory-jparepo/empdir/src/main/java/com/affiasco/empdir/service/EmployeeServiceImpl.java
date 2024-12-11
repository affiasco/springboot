package com.affiasco.empdir.service;

import com.affiasco.empdir.dao.EmployeeRepository;
import com.affiasco.empdir.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository EmployeeRepository) {
        employeeRepository = EmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find employee id: " + employeeId);
        }
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
