package com.aihexa.week5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService(new InMemoryUserRepository());
    }

    @Test
    void shouldRegisterValidUser() throws SQLException {
        User user = service.register("Ada Lovelace", "ADA@example.com");
        assertNotNull(user.id());
        assertEquals("ada@example.com", user.email());
    }

    @Test
    void shouldRejectDuplicateEmail() throws SQLException {
        service.register("Ada", "ada@example.com");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.register("Second Ada", "ADA@example.com"));
        assertEquals("E-posta zaten kayıtlı", ex.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void shouldRejectBlankName(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> service.register(name, "user@example.com"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid", "@example.com", "user@"})
    void shouldRejectInvalidEmail(String email) {
        assertThrows(IllegalArgumentException.class,
                () -> service.register("User", email));
    }
}
