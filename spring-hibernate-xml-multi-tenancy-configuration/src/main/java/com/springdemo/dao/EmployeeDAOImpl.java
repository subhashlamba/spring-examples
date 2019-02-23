package com.springdemo.dao;

import com.springdemo.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Subhash Lamba on 22-01-2017.
 */
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public List<Employee> list() {
        return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }
}
