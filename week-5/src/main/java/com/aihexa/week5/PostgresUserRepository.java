package com.aihexa.week5;

import java.sql.*;
import java.util.Optional;

public class PostgresUserRepository implements UserRepository {
    private final Connection connection;

    public PostgresUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User save(User user) throws SQLException {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?) RETURNING id";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.name());
            ps.setString(2, user.email());
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return new User(rs.getLong("id"), user.name(), user.email());
            }
        }
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("SELECT id, name, email FROM users WHERE email = ?")) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return Optional.empty();
                return Optional.of(new User(rs.getLong("id"), rs.getString("name"), rs.getString("email")));
            }
        }
    }

    @Override
    public long count() throws SQLException {
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM users")) {
            rs.next();
            return rs.getLong(1);
        }
    }

    @Override
    public void deleteAll() throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("DELETE FROM users");
        }
    }
}
