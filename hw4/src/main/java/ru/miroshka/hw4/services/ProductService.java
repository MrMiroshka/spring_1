package ru.miroshka.hw4.services;

import org.springframework.stereotype.Service;
import ru.miroshka.hw4.data.Product;
import ru.miroshka.hw4.repositories.ProductRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return this.productRepository.getProducts();
    }

    public Product getProduct(Long id) {
        return this.productRepository.getProduct(id);
    }

    public void delProductById(Long id) {
        this.productRepository.delProductById(id);
    }

    public void addProduct(Long id, String name, Integer cost) {
        this.productRepository.addProduct(id, name, cost);
    }
}
