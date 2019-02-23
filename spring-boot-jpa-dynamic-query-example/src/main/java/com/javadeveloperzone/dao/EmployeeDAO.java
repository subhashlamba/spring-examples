package com.javadeveloperzone.dao;

import com.javadeveloperzone.model.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Java Developer Zone on 03-08-2017.
 */
@Repository
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee,Long>,JpaSpecificationExecutor<Employee> {

    List<Employee> findEmployeeByEmployeeNameStartingWith(String name); // fetch list of Employee which start with
    List<Employee> findEmployeeByEmployeeRole(String role);         // fetch Employee by role
    List<Employee> findAll();                           // fetch all Employee
}
