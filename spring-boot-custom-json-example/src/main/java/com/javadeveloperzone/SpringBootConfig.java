package com.javadeveloperzone;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.javadeveloperzone.json.DateConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.Instant;


/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }

   /* @Bean
    public Module module(){
        SimpleModule module = new SimpleModule();
        module.addSerializer(Instant.class, new DateConverter.Serialize());
        module.addDeserializer(Instant.class, new DateConverter.Deserialize());
        return module;
    }*/
}
