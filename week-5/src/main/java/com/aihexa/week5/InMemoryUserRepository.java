package com.aihexa.week5;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> users = new LinkedHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public User save(User user) {
        if (findByEmailUnchecked(user.email()).isPresent()) {
            throw new IllegalArgumentException("E-posta zaten kayıtlı");
        }
        long id = user.id() == null ? sequence.getAndIncrement() : user.id();
        User saved = new User(id, user.name(), user.email());
        users.put(id, saved);
        return saved;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return findByEmailUnchecked(email);
    }

    private Optional<User> findByEmailUnchecked(String email) {
        return users.values().stream().filter(u -> u.email().equalsIgnoreCase(email)).findFirst();
    }

    @Override
    public long count() { return users.size(); }

    @Override
    public void deleteAll() { users.clear(); }
}
