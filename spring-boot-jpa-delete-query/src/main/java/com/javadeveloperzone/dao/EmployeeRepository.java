package com.javadeveloperzone.dao;

import com.javadeveloperzone.model.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Java Developer Zone on 03-08-2017.
 */
@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    @Override
    void delete(Long empId);

    int deleteEmployeeByEmployeeName(String name);

    @Override
    void delete(Iterable<? extends Employee> iterable);

    @Override
    void deleteAll();

    @Modifying      // to mark delete or update query
    @Query(value = "DELETE FROM Employee e WHERE e.employeeName = :name")       // it will delete all the record with specific name
    int deleteByName(@Param("name") String name);

    @Modifying
    @Query(value = "DELETE FROM Employee WHERE employeeName = :name",nativeQuery = true)
    int deleteByNameNative(@Param("name") String name);


}
