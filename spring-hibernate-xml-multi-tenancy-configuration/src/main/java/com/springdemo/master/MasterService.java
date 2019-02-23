package com.springdemo.master;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by Subhash Lamba on 22-01-2017.
 */

public class MasterService {
    public static HashMap<String, DataSource> getDataSourceHashMap() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo_database");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/demo_database_1");
        dataSource1.setUsername("root");
        dataSource1.setPassword("");

        HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource);
        hashMap.put("tenantId2", dataSource1);
        return hashMap;
    }
}
