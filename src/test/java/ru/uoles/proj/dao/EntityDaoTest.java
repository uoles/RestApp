package ru.uoles.proj.dao;

import oracle.jdbc.pool.OracleDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.testcontainers.containers.OracleContainer;
import ru.uoles.proj.dao.mapper.EntityMapper;
import ru.uoles.proj.model.Entity;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.uoles.proj.service.PaymentServiceImpl.GET_ENTITIES;
import static ru.uoles.proj.service.PaymentServiceImpl.mapToParams;

@RunWith(JUnitPlatform.class)
@DisplayName("Тестирование работы с базой данных")
class EntityDaoTest {

    private OracleContainer oracleContainer;
    private EntityDaoImpl entityDao;

    @BeforeEach
    public void initDockerDB() throws SQLException {
        oracleContainer = new OracleContainer("oracleinanutshell/oracle-xe-11g")
                .withEnv("ORACLE_ALLOW_REMOTE", "true")
                .withEnv("ALWAYS_PULL_IMAGE", "false");
        oracleContainer.start();
        System.out.println("===== initDockerDB: start");

        ScriptUtils.executeSqlScript(dataSource(oracleContainer).getConnection(), new ClassPathResource("db_test/h2-schema.sql"));
        ScriptUtils.executeSqlScript(dataSource(oracleContainer).getConnection(), new ClassPathResource("db_test/h2-data.sql"));
        System.out.println("===== initDockerDB: sql scripts loads");

        entityDao = new EntityDaoImpl(new NamedParameterJdbcTemplate(dataSource(oracleContainer)));
    }

    @Test
    @DisplayName("Вызов метода query: получение Entity по параметру Message")
    public void queryTest() {
        Entity entityExpected = new Entity(1L, "text1");

        List<Entity> result = entityDao.query(
                GET_ENTITIES, mapToParams("message1"), new EntityMapper()
        );

        assertAll(
                () -> assertNotNull(result),
                () -> assertFalse(result.isEmpty()),
                () -> assertEquals(1, result.size()),
                () -> assertEquals(entityExpected, result.get(0))
        );

        System.out.println("===== test");
    }

    @AfterEach
    public void closeDockerDB() {
        oracleContainer.close();
        System.out.println("===== closeDockerDB: close");
    }

    private DataSource dataSource(OracleContainer oracleContainer) throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL(oracleContainer.getJdbcUrl());
        dataSource.setUser("system");
        dataSource.setPassword("oracle");
        dataSource.setDriverType(oracleContainer.getDriverClassName());
        return dataSource;
    }
}
