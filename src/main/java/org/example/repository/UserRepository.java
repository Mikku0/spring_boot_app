package org.example.repository;

import org.example.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public UserRepository() {
        // Dodaj przykładowe dane
        save(new User() {{ setId(counter.incrementAndGet()); setUsername("john_doe"); setEmail("john@example.com"); setPassword("password123"); }});
        save(new User() {{ setId(counter.incrementAndGet()); setUsername("jane_doe"); setEmail("jane@example.com"); setPassword("password123"); }});
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.removeIf(u -> u.getId().equals(user.getId()));
        users.add(user);
        return user;
    }

    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}