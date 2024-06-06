package com.contable.account.companies.application;

import com.contable.shared.domain.bus.DomainEventSubscriber;
import com.contable.shared.domain.companies.CompanyCreated;
import org.flywaydb.core.Flyway;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@DomainEventSubscriber({CompanyCreated.class})
public class CreateSchemaOnCompanyCreated {

    private final JdbcTemplate jdbcTemplate;

    private final Flyway flyway;

    public CreateSchemaOnCompanyCreated(JdbcTemplate jdbcTemplate, Flyway flyway) {
        this.jdbcTemplate = jdbcTemplate;
        this.flyway = flyway;
    }

    @EventListener
    public void on(CompanyCreated event) {
        createSchema(event.getIdentity());
    }

    private void createSchema(String schema) {
        Flyway f = Flyway.configure()
                .configuration(flyway.getConfiguration())
                .schemas(schema)
                .defaultSchema(schema)
                .load();
        f.migrate();
    }

    private boolean ensureSchemaCanBeCreated(String schema) {
        try {
            var sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = '" + schema + "'";
            var name = jdbcTemplate.queryForObject(sql, String.class);
            return name == null;

        } catch (Exception e) {

        }
        return true;
    }
}
