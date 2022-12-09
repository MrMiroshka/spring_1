package ru.miroshka.hw6.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import ru.miroshka.hw6.data.Product;
import ru.miroshka.hw6.repositories.ProductDao;
import ru.miroshka.hw6.service.ProductService;


import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsController {
    @Autowired
    private ProductService productService;

    public List<Product> getProduct(Long id) {
        List<Product> m = new ArrayList<>();
        m.add(productService.getProduct(id));
        return m;
    }

    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    public void delProductById(Long id) {
        this.productService.delProductById(id);
    }


    public void addProduct( String name,  Integer cost) {
        this.productService.addProduct(null,name,cost);
    }


}
