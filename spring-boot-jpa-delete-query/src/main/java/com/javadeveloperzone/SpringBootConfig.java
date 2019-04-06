package com.javadeveloperzone;

import com.javadeveloperzone.dao.EmployeeRepository;
import com.javadeveloperzone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Java Developer Zone on 19-07-2017.
 */

@SpringBootApplication
// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }


}
@Component
class Init implements ApplicationRunner{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        if(employeeRepository.findOne(1L)!=null){
            employeeRepository.delete(1L);
        }

        java.util.List<Employee>  employees=new ArrayList<>();
        employees.add(employeeRepository.findOne(2L));
        employees.add(employeeRepository.findOne(3L));
        employeeRepository.delete(new ArrayList<>());

        int deleteCounted =  employeeRepository.deleteByName("Harry");            // Delete all the records whole name is Harry
        System.out.println("Total Deleted Records: "+deleteCounted);

        employeeRepository.deleteByNameNative("Harry");

        employeeRepository.deleteEmployeeByEmployeeName("Harry");
        // employeeRepository.deleteAll(); // To delete all the records

        String employeeName = "Harry";
        java.util.List<Employee> employeeList = employeeRepository.findAll(new Specification<Employee>(){
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(employeeName!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("employeeName"), employeeName)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        employeeRepository.delete(employeeList);

    }
}
