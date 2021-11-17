package br.com.digitalinnovation.abruzzo.project_cities_api.dao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SqlGroup({
        @Sql(scripts = "/scripts/PostgreSQL/INICIALIZACAO_BASE_DADOS.sql.sql",
                config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)),
        @Sql("/import_employees.sql")})
class SpringBootSqlGroupAnnotationIntegrationTest {

    @Autowired
    private StateRepository employeeRepository;

    @Test
    public void testLoadDataForTestCase() {
        assertEquals(28, employeeRepository.findAll().size());
    }
}