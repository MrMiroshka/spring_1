package ru.miroshka.hw12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.miroshka.hw12.data.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);
}
