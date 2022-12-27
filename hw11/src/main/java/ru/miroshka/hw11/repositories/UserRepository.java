package ru.miroshka.hw11.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.miroshka.hw11.data.User;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    Optional<User> findByUserName(String userName);
}
