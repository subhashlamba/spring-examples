package com.javadeveloperzone.controller;

import com.javadeveloperzone.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
public class EmployeeController {
    @RequestMapping("getEmployees")
    public List<Employee> getEmployees() {
        return Employee.getEmployee();
    }
}
