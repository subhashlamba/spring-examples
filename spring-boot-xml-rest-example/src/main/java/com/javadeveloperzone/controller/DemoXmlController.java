package com.javadeveloperzone.controller;

import com.javadeveloperzone.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by Lenovo on 19-07-2017.
 * This is spring boot rest xml example or spring boot xml response example
 */
@RestController
public class DemoXmlController {

    @RequestMapping("/demo")
    public Employee demo() {            // it will return response in xml and json
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Java Developer Zone");
        employee.setRole("HR");
        return employee;
    }
}
