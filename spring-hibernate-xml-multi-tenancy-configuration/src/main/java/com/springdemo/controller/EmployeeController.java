package com.springdemo.controller;

import com.springdemo.model.Employee;
import com.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public String createEmployee(ModelMap model) {
        return "createEmployee";
    }

    @RequestMapping(value = "viewEmployee", method = RequestMethod.GET)
    public String viewEmployee(ModelMap model) {
        model.addAttribute("employees", employeeService.list());
        return "viewEmployee";
    }

    @RequestMapping(value = "saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:viewEmployee";
    }

}