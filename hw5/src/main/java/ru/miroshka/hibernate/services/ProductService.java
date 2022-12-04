package ru.miroshka.hibernate.services;

import org.springframework.stereotype.Service;
import ru.miroshka.hibernate.data.Product;
import ru.miroshka.hibernate.repositories.ProductDao;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return this.productDao.getProducts();
    }

    public Product getProduct(Long id) {
        return this.productDao.getProduct(id);
    }

    public void delProductById(Long id) {
        this.productDao.delProductById(id);
    }

    public void addProduct(Long id, String name, Integer cost) {
        this.productDao.saveOrUpdate(new Product(id, name, cost));
    }
}
