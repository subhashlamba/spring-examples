package com.javadeveloperzone.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Employee implements Serializable{

    private int no;

    private String name;

    private String designation;

    private String gender;
    public Employee(){

    }
    public Employee(int no, String name, String designation, String gender ) {
        this.no = no;
        this.name = name;
        this.designation = designation;
        this.gender = gender;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public static java.util.List<Employee> getEmployee() {
        java.util.List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Bob", "Developer", "Male"));
        employees.add(new Employee(2, "Joy", "Sr. Developer", "Male"));
        employees.add(new Employee(3, "John", "CEO", "Male"));
        employees.add(new Employee(4, "Bat", "Developer", "Male"));
        employees.add(new Employee(5, "Jolly", "Developer", "Female"));
        employees.add(new Employee(6, "Bobby", "Developer", "Female"));
        return employees;
    }


}
