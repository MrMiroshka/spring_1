package ru.miroshka.hw8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miroshka.hw8.data.Product;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {
    List<Product> findByCostGreaterThan(int cost);
    List<Product> findByCostLessThan(int cost);
    List<Product> findByCostBetween(int min, int max);
}
