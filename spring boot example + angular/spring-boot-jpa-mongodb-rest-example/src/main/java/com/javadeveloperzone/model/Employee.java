package com.javadeveloperzone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Java Developer Zone on 03-08-2017.
 */
@Document(collection = "Employee")
public class Employee {
    public Employee(){

    }
    public Employee(String name,String role){
        this.employeeName = name;
        this.employeeRole = role;
    }
    @Id                                                     // primary key
    private String employeeId;

    private String employeeName;

    private String employeeRole;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
