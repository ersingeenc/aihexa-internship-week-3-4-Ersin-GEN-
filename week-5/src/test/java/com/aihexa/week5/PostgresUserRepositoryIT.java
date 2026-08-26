package com.aihexa.week5;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class PostgresUserRepositoryIT {
    @Container
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("week5")
            .withUsername("test")
            .withPassword("test");

    private Connection connection;
    private PostgresUserRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        connection = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
        applyMigration(connection);
        repository = new PostgresUserRepository(connection);
        repository.deleteAll();
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null) connection.close();
    }

    @Test
    void shouldPersistAndFindUser() throws SQLException {
        User saved = repository.save(new User(null, "Grace Hopper", "grace@example.com"));
        assertNotNull(saved.id());
        assertEquals("Grace Hopper", repository.findByEmail("grace@example.com").orElseThrow().name());
    }

    @Test
    void shouldRollbackTransaction() throws SQLException {
        connection.setAutoCommit(false);
        repository.save(new User(null, "Rollback User", "rollback@example.com"));
        connection.rollback();
        assertEquals(0, repository.count());
        connection.setAutoCommit(true);
    }

    @Test
    void shouldEnforceUniqueEmailConstraint() throws SQLException {
        repository.save(new User(null, "First", "same@example.com"));
        assertThrows(SQLException.class,
                () -> repository.save(new User(null, "Second", "same@example.com")));
    }

    private static void applyMigration(Connection connection) throws IOException, SQLException {
        String sql;
        try (var in = PostgresUserRepositoryIT.class.getResourceAsStream("/schema.sql")) {
            if (in == null) throw new IOException("schema.sql bulunamadı");
            sql = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        try (Statement st = connection.createStatement()) {
            st.execute(sql);
        }
    }
}
