package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JavaDeveloperZone on 28-04-2017.
 * Spring boot set active profile at run time or programmatically
 */

@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication=new SpringApplication(SpringBootConfig.class);
        String[] profiles= new String[]{"production","production-extra"};
        springApplication.setAdditionalProfiles(profiles);
        springApplication.run(args);
    }
}
