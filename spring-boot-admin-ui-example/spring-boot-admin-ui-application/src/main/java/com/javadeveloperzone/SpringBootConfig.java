package com.javadeveloperzone;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@EnableAdminServer
// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootConfig.class);
        springApplication.run(args);
    }
}
