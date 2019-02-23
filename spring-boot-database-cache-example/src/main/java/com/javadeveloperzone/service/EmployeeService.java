package com.javadeveloperzone.service;

import com.javadeveloperzone.model.Employee;

import java.util.List;

/**
 * Created by JavaDeveloperZone on 04-04-2018.
 */

public interface EmployeeService {

    List<Employee> findAll();
    Employee save(Employee employee);
    void delete(long employeeId);
}
