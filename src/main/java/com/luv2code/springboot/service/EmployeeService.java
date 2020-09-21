package com.luv2code.springboot.service;

import com.luv2code.springboot.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface EmployeeService {


    public List<Employee> findAll();

    Employee findById(int employeeId);

    void save(Employee employee);

    void deleteById(int id);
}
