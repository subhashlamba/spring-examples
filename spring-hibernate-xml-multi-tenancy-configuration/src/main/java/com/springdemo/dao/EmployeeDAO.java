package com.springdemo.dao;

import com.springdemo.model.Employee;

import java.util.List;

/**
 * Created by Subhash Lamba on 22-01-2017.
 */
public interface EmployeeDAO {
    public void save(Employee employee);
    public List<Employee> list();
}
