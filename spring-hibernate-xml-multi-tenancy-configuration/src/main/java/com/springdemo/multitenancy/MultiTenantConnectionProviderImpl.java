package com.springdemo.multitenancy;

import com.springdemo.master.MasterService;
import org.hibernate.service.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;

import javax.sql.DataSource;
/**
 * Created by Subhash Lamba on 22-01-2017.
 */

public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Override
    protected DataSource selectAnyDataSource() {
        return MasterService.getDataSourceHashMap().get("tenantId1");
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        return MasterService.getDataSourceHashMap().get(tenantIdentifier);
    }

}
