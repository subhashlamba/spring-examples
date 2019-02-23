package com.javadeveloperzone.dao;

import com.javadeveloperzone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by JavaDeveloperZone on 03-08-2017.
 */
@Component
public class EmployeeDAO {

    @Autowired
    @Qualifier(value = "datasource1")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier(value = "datasource2")
    private JdbcTemplate jdbcTemplate1;


    public java.util.List<Employee> getEmployeeList() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from employee");
        return maps.stream().map(map -> {
            Employee employee = new Employee();
            employee.setEmployeeName(map.get("employeeName").toString());
            employee.setEmployeeId((Integer) map.get("employeeId"));
            employee.setEmployeeRole((String) map.get("employeeRole"));
            return employee;
        }).collect(Collectors.toList());
    }
}
