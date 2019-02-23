package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan({"com.javadeveloperzone"})

// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApplication.class, args);            // it wil start application
    }
}
