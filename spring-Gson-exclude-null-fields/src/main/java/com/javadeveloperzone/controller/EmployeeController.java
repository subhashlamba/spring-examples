package com.javadeveloperzone.controller;

import com.javadeveloperzone.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
public class EmployeeController {

    @RequestMapping("/getEmployee")
    public Employee getEmployees() {
        Employee employee=new Employee();
        employee.setEmployeeId(19);
       // employee.setEmployeeName("Harry");
        employee.setEmployeeRole("DEVELOPER");
        return employee;
    }
}
