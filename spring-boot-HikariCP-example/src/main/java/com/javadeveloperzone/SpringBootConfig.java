package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan
// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Connection Polling datasource : "+ dataSource);  // check connection pooling
    }
}
