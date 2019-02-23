package com.javadeveloperzone.dao;

import com.javadeveloperzone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by JavaDeveloperZone on 03-08-2017.
 */
@Component
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public java.util.List<Employee> getEmployeeList() {
        List<Map<String, Object>> employees = jdbcTemplate.queryForList("select * from employee");
        return employees.stream().map(e -> {
            Employee employee = new Employee();
            employee.setEmployeeName(e.get("employeeName").toString());
            employee.setEmployeeId((Integer) e.get("employeeId"));
            employee.setEmployeeRole((String) e.get("employeeRole"));
            return employee;
        }).collect(Collectors.toList());
    }
}
