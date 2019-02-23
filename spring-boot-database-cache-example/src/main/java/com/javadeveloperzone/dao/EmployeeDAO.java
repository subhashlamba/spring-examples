package com.javadeveloperzone.dao;

import com.javadeveloperzone.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by JavaDeveloperZone on 03-08-2017.
 */
@Repository
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee,Long> {
    List<Employee> findAll();                           // fetch all Employee
}
