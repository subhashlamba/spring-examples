package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by JavaDeveloperZone on 06-16-2019.
 */

@SpringBootApplication
public class SpringBootConfig  {



    public static void main(String[] args)  {
        SpringApplication springApplication = new SpringApplication(SpringBootConfig.class);
        springApplication.run(args);
    }

}