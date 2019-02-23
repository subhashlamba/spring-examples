package com.javadeveloperzone.model;

import java.util.Date;

/**
 * Created by Java Developer Zone on 29-08-2017.
 */

public class Employee {
    private int id;
    private String name;
    private String role;
    private Date jainDate=new Date();

    public Date getJainDate() {
        return jainDate;
    }

    public void setJainDate(Date jainDate) {
        this.jainDate = jainDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
