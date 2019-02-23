package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by JavaDeveloperZone on 12-05-2018.
 */
public class V4__Another_user implements SpringJdbcMigration{
    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.execute("INSERT INTO employee\n" +
                "(employeeId, employeeName, employeeRole)\n" +
                "VALUES (14, 'Zone', 'ADMN');");
    }
}
