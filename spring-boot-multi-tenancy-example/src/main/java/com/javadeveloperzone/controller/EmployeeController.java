package com.javadeveloperzone.controller;

import com.javadeveloperzone.dao.EmployeeDAO;
import com.javadeveloperzone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Java Developer Zone on 19-07-2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "emploeeList")
    public java.util.List<Employee> emploeeList() {
        return employeeDAO.findAll();
    }

}
