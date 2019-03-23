package com.javadeveloperzone.dao;

import com.javadeveloperzone.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;


/**
 * Created by Java Developer Zone on 03-08-2017.
 */
@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee,Long>{

    List<Employee> findAll();

    // where clause

    List<Employee> findByEmployeeName(@Param("name") String name);

    @Query("SELECT e from Employee e where e.employeeName =:name ")
    List<Employee> findByName(@Param("name") String name);

    @Query(value = "SELECT * from Employee e where e.employeeName =:name ", nativeQuery = true)
    List<Employee> findByNameNative(@Param("name") String name);

    // where with AND

    List<Employee> findByEmployeeNameAndEmployeeRole(@Param("name")String name,@Param("role") String role);

    @Query("SELECT e from Employee e where e.employeeName =:name AND e.employeeRole =:role")
    List<Employee> findByNameAndRole(@Param("name") String name,@Param("role")String role);

    @Query(value = "SELECT * from Employee e where e.employeeName =:name AND e.employeeRole = :role ", nativeQuery = true)
    List<Employee> findByNameAndRoleNative(@Param("name") String name, @Param("role")String role);


    // where with OR
    List<Employee> findByEmployeeNameOrEmployeeRole(@Param("name")String name,@Param("role") String role);

    @Query("SELECT e from Employee e where e.employeeName =:name or e.employeeRole =:role")
    List<Employee> findByNameOrRole(@Param("name") String name,@Param("role")String role);

    @Query(value = "SELECT * from Employee e where e.employeeName =:name or e.employeeRole = :role ", nativeQuery = true)
    List<Employee> findByNameOrRoleNative(@Param("name") String name, @Param("role")String role);

    // where with BETWEEN

    List<Employee> findByJoinedDateBetween(@Temporal(TemporalType.DATE) @Param("startDate") Date startDate,@Temporal(TemporalType.DATE) @Param("endDate")Date endDate);

    @Query("SELECT e from Employee e where e.joinedDate between :startDate and :endDate")
    List<Employee> findByJoinedDate(@Temporal(TemporalType.DATE) @Param("startDate") Date startDate, @Temporal(TemporalType.DATE) @Param("endDate") Date endDate);

    @Query(value = "SELECT * from Employee e where e.joinedDate between :startDate and :endDate", nativeQuery = true)
    List<Employee> findByJoinedDateBetweenNative(@Temporal(TemporalType.DATE) @Param("startDate") Date startDate,@Temporal(TemporalType.DATE) @Param("endDate")Date endDate);

    // where with Paging

    Page<Employee> findByEmployeeName(String name, Pageable pageable );

    @Query("SELECT e from Employee e where e.employeeName = :name ")
    Page<Employee> findByName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT * from Employee e where e.employeeName = :name /*#pageable*/ ",  nativeQuery = true)
    Page<Employee> findByNameNative(@Param("name") String name, Pageable pageable);


}
