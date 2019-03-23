package com.javadeveloperzone;

import com.javadeveloperzone.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

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
        employeeRepository.findAll();

        employeeRepository.findByEmployeeName("Jone");
        employeeRepository.findByName("Jone");
        employeeRepository.findByNameNative("Jone");

        employeeRepository.findByEmployeeNameAndEmployeeRole("Jone","Employee");
        employeeRepository.findByNameAndRole("Jone","Employee");
        employeeRepository.findByNameAndRoleNative("Jone","Employee");

        employeeRepository.findByEmployeeNameOrEmployeeRole("Jone","Employee");
        employeeRepository.findByNameOrRole("Jone","Employee");
        employeeRepository.findByNameOrRoleNative("Jone","Employee");

        employeeRepository.findByJoinedDate(new Date(),new Date());
        employeeRepository.findByJoinedDateBetweenNative(new Date(),new Date());
        employeeRepository.findByJoinedDateBetween(new Date(),new Date());


        employeeRepository.findByEmployeeName("Jone", new PageRequest(1,10));
        employeeRepository.findByName("Jone", new PageRequest(1,10));
        employeeRepository.findByNameNative("Jone", new PageRequest(1,1));

    }
}
