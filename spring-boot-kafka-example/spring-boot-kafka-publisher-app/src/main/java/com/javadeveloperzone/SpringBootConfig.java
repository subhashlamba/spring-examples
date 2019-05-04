package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author subhash lamba
 */
@SpringBootApplication
public class SpringBootConfig implements CommandLineRunner {


    private static final String TOPIC = "topic1";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootConfig.class);
        springApplication.setAddCommandLineProperties(false);  // it will disable command like option, when set false then it will ignore command line option.
        springApplication.run(args);
    }

    @Override
    public void run(String... strings) {
        for(int i=0; i<10; i++) {
            this.kafkaTemplate.send(TOPIC, "Message "+i);
        }
    }
}
