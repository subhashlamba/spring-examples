package com.javadeveloperzone.service;

import com.javadeveloperzone.repository.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public void delete(String employeeId) {
        employeeRepository.delete(employeeRepository.findOne(employeeId));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
}
