package com.javadeveloperzone.model;

import javax.persistence.*;

/**
 * Created by Java Developer Zone on 03-08-2017.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id                                                     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "employeeRole")
    private String employeeRole;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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
