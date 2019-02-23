package com.javadeveloperzone.service;

import com.javadeveloperzone.dao.EmployeeDAO;
import com.javadeveloperzone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 04-04-2018.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
    }

    public List<Employee> findByCriteria(String employeeName){
        return employeeDAO.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(employeeName!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("employeeName"), employeeName)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }

    public List<Employee> findByPagingCriteria(String employeeName,Pageable pageable){
        Page page = employeeDAO.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(employeeName!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("employeeName"), employeeName)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);

        page.getTotalElements();        // get total elements
        page.getTotalPages();           // get total pages
        return page.getContent();       // get List of Employee
    }

    public List<Employee> findByCriteria(String employeeName,String employeeRole){
        return employeeDAO.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(employeeName!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("employeeName"), "%"+employeeName+"%")));
                }
                if(employeeRole!=null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("employeeRole"), employeeRole)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }

    public List<Employee> findByLikeCriteria(String text){
        return employeeDAO.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(text!=null) {
                    predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("employeeName"), "%" + text + "%"),
                            criteriaBuilder.like(root.get("employeeEmail"), "%" + text + "%")));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }
    public List<Employee> findByLikeAndBetweenCriteria(String text,int employeeIdStart, int employeeIdEnd){
        return employeeDAO.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(text!=null) {
                    predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("employeeName"), "%" + text + "%"),
                            criteriaBuilder.like(root.get("employeeEmail"), "%" + text + "%")));
                }
                if(employeeIdStart!=0 && employeeIdEnd!=0){
                    predicates.add(criteriaBuilder.between(root.get("employeeId"),employeeIdStart,employeeIdEnd));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }

    @Override
    public List<Employee> findEmployeeByEmployeeNameStartingWith(String name) {
        return employeeDAO.findEmployeeByEmployeeNameStartingWith(name);
    }

    @Override
    public List<Employee> findEmployeeByEmployeeRole(String role) {
        return employeeDAO.findEmployeeByEmployeeRole(role);
    }

    @Override
    public void delete(long employeeId) {
        Employee employee = employeeDAO.findOne(employeeId);
        employeeDAO.delete(employee);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
}
