package ru.miroshka.hw6.service;

import org.springframework.stereotype.Service;
import ru.miroshka.hw6.data.Product;
import ru.miroshka.hw6.repositories.ProductDao;

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
        Product product = new Product();
        product.setName(name);
        product.setCost(cost);
        product.setId(id);
        this.productDao.saveOrUpdate(product);
    }
}
