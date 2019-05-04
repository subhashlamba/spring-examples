package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author Subhash Lamba
 */
@SpringBootApplication
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootConfig.class);
        springApplication.setAddCommandLineProperties(false);  // it will disable command like option, when set false then it will ignore command line option.
        springApplication.run(args);
    }

    @KafkaListener(topics = "topic1", group = "group_id")
    public void receive(String payload) {
        System.out.println("Payload:"+payload);
    }
}
