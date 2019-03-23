package com.javadeveloperzone.service;

import com.javadeveloperzone.dao.EmployeeRepository;
import com.javadeveloperzone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lenovo on 04-04-2018.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public List<Employee> findEmployeeByEmployeeNameStartingWith(String name) {
        return employeeDAO.findByEmployeeName(name);
    }

    @Override
    public List<Employee> findEmployeeByEmployeeRole(String role) {
        return employeeDAO.findByNameNative(role);
    }

    @Override
    public void delete(long employeeId) {
        Employee employee = employeeDAO.findOne(employeeId);
        employeeDAO.delete(employee);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
}
