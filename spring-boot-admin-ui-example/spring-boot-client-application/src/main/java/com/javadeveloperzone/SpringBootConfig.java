package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootConfig.class);
        springApplication.run(args);
    }
}
