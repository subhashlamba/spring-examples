package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan
@EnableEurekaServer // Indicate Eureka Server Application
public class EurekaServerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaServerApplication.class, args);            // it wil start application

    }
}
