package com.luv2code.springboot.dao;

import com.luv2code.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//for query methods jpa data
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();
}
