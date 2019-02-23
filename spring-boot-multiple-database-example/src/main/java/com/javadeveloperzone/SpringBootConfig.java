package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan
// Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }

    @Bean(value = "datasource2")
    @ConfigurationProperties("app.client")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(value = "datasource1")
    @ConfigurationProperties("app.master")
    @Primary
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Autowired
    @Qualifier("datasource2")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    @Autowired
    @Qualifier("datasource1")
    public JdbcTemplate jdbcTemplate1(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
