package com.javadeveloperzone;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }
    /*@Bean
    GsonBuilder gsonBuilder(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        //gsonBuilder.serializeNulls();
        return gsonBuilder;
    }*/
}
