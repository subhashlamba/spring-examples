package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Java Developer Zone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan
@EnableCaching      // to enable spring cache
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);    // run spring boot application          // it wil start application
    }
}
