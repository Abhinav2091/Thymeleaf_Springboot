package com.luv2code.springboot.controller;


import com.luv2code.springboot.entity.Employee;
import com.luv2code.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeDbController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        //add to model
        model.addAttribute("employees", employeeList);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save the employee
        employeeService.save(employee);

        //use a redirect to prevent duplicate Submission
        return "redirect:/api/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdateEmployee(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        //use a redirect to prevent duplicate Submission
        return "redirect:/api/employees/list";
    }
}
