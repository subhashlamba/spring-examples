package com.springdemo.service;

import com.springdemo.dao.EmployeeDAO;
import com.springdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Subhash Lamba on 22-01-2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public List<Employee> list() {
        return employeeDAO.list();
    }
}
