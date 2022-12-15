package ru.miroshka.hw8.service;

import org.springframework.stereotype.Service;
import ru.miroshka.hw8.data.Product;
import ru.miroshka.hw8.repositories.ProductDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductDao productRepository;

    public ProductService(ProductDao productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        Iterable<Product> products = this.productRepository.findAll();

        List<Product> productsList = new ArrayList<>();
        for (Product p: products) {
            productsList.add(p);
        }
        return productsList;
    }

    public List<Product> getProduct(Long id) {
        return this.productRepository.findById(id).stream().toList();
    }

    public void delProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public void addProduct(String name, Integer cost) {
        this.productRepository.save(new Product(name,cost));
    }
}
