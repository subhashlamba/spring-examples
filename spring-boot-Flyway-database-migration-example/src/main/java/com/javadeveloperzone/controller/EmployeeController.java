package com.javadeveloperzone.controller;

import com.javadeveloperzone.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/getEmployeeList")
    public java.util.List getEmployeeList() {
        return employeeDAO.getEmployeeList();
    }
}
