package com.aihexa.week5;

import java.sql.SQLException;
import java.util.Locale;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(String name, String email) throws SQLException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("İsim boş olamaz");
        }
        if (email == null || !email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Geçerli bir e-posta girilmelidir");
        }
        String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);
        if (repository.findByEmail(normalizedEmail).isPresent()) {
            throw new IllegalArgumentException("E-posta zaten kayıtlı");
        }
        return repository.save(new User(null, name.trim(), normalizedEmail));
    }
}
