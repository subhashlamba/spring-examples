package com.javadeveloperzone.controller;

import com.javadeveloperzone.dao.EmployeeDAO;
import com.javadeveloperzone.dao.EmployeeDAO1;
import com.javadeveloperzone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    EmployeeDAO1 employeeDAO1;

    @RequestMapping("/getEmployeeList")
    public java.util.List getEmployeeList() {
        return employeeDAO.getEmployeeList();
    }

    @RequestMapping("/getMasterData")
    public java.util.List getMasterData() {
        return employeeDAO1.getEmployeeList();
    }
}
