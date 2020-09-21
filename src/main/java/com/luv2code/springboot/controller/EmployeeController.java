package com.luv2code.springboot.controller;


import com.luv2code.springboot.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Abhinav", "Sharma", "abhi@gmail.com"));
        employees.add(new Employee(2, "Aju", "Sharma", "aju@gmail.com"));
        employees.add(new Employee(3, "Abhi", "Sharma", "aaa@gmail.com"));
    }

    //add a mapping for  /list
    @GetMapping(value = "/list")
    public String employeeList(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    @GetMapping(value = "/bootstrap-list")
    public String bootstrapEmployeeList(Model model) {
        model.addAttribute("employees", employees);
        return "bootstrap-list-employees";
    }

}
