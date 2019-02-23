package com.javadeveloperzone;

import com.javadeveloperzone.master.MasterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * Created by Java Developer Zone on 19-07-2017.
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.javadeveloperzone")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.javadeveloperzone")
public class SpringBootConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }

    @Bean
    public DataSource dataSource(){
        CustomRoutingDataSource customDataSource=new CustomRoutingDataSource();
        customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
        return customDataSource;
    }

}

