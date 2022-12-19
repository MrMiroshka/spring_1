package ru.miroshka.hw9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.miroshka.hw9.data.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findByCostGreaterThan(int cost);

    List<Product> findByCostLessThan(int cost);

    List<Product> findByCostBetween(int min, int max);


    Optional<Product> findByName(String name);

}
