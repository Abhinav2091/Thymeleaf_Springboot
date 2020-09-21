package com.luv2code.springboot.serviceImpl;

import com.luv2code.springboot.dao.EmployeeRepository;
import com.luv2code.springboot.entity.Employee;
import com.luv2code.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("employeeSpringDataJPAServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (result.isPresent())
            employee = result.get();

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }
}
