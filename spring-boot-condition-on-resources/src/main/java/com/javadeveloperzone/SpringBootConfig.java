package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by JavaDeveloperZone on 06-16-2019.
 */

@SpringBootApplication
public class SpringBootConfig implements CommandLineRunner {

    @Autowired
    private ExampleService exampleService;

    public static void main(String[] args)  {
        SpringApplication springApplication = new SpringApplication(SpringBootConfig.class);
        springApplication.run(args);
    }

    //@ConditionalOnResource(resources = "file:\\C:\\data\\example.json")
    @ConditionalOnResource(resources = {"classpath:example.json","classpath:example1.json"})
    @Bean
    ExampleService exampleService() throws Exception{
        System.out.println("Creating bean of example json service...");

        File file=new ClassPathResource("example.json", this.getClass().getClassLoader()).getFile();
        return new ExampleService(new String(Files.readAllBytes(Paths.get(file.toURI()))));
    }

    @ConditionalOnMissingBean
    @Bean
    ExampleService exampleServiceNo() throws Exception{
        System.out.println("Creating bean of example json service...");
        return new ExampleService("{name:developer}");      // default value
    }

    @Override
    public void run(String... args) {
        System.out.print(exampleService.getJson());
    }
}