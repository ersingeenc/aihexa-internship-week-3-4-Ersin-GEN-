package com.aihexa.week5;

import java.sql.SQLException;
import java.util.Optional;

public interface UserRepository {
    User save(User user) throws SQLException;
    Optional<User> findByEmail(String email) throws SQLException;
    long count() throws SQLException;
    void deleteAll() throws SQLException;
}
