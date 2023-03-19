package ru.miroshka.hw11.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.miroshka.hw11.data.Authority;
@Repository
public interface AuthorityRepository extends CrudRepository<Authority,Long> {
}
