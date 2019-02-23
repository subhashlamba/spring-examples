package com.javadeveloperzone.controller;

import com.javadeveloperzone.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})         // for individual controller, allowed all request from localhost:4200
public class EmployeeController {

    @CrossOrigin(origins = {"http://localhost:4200"})         // for individual controller, allowed all request from localhost:4200
    @RequestMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return Employee.getEmployee();
    }
    @DeleteMapping("/delete/{id}")
    public List<Employee> getEmployees(@PathVariable("id")long id) {
        return Employee.getEmployee();
    }
}
