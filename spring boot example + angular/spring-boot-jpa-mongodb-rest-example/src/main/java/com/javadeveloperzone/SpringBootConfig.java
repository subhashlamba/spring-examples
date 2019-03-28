package com.javadeveloperzone;

import com.javadeveloperzone.model.Employee;
import com.javadeveloperzone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

/**
 * Created by Java Developer Zone on 19-07-2017.
 */

@SpringBootApplication
@EnableMongoRepositories("com.javadeveloperzone.repository")
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
        employeeRepository.save(new Employee("Jone","DEVELOPER"));
    }
}