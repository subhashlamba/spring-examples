package com.springdemo.service;

import com.springdemo.model.Employee;

import java.util.List;

/**
 * Created by Subhash Lamba on 22-01-2017.
 */
public interface EmployeeService {
    public void save(Employee employee);
    public List<Employee> list();
}
