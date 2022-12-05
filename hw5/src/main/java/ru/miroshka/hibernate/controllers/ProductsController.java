package ru.miroshka.hibernate.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.miroshka.hibernate.data.Product;
import ru.miroshka.hibernate.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    private ProductService productService;


    @GetMapping("/getProduct/{id}")
    public List<Product> getProduct(Model model, @PathVariable Long id) {
        //model.addAttribute("product", productService.getProduct(id));
        List<Product> m = new ArrayList<>();
        m.add(productService.getProduct(id));
        return m;
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }


    @GetMapping("/delete/{id}")
    public void delProductById(@PathVariable Long id) {
        this.productService.delProductById(id);
    }

    @GetMapping("/addProduct")
    public void addProduct(@RequestParam String name, @RequestParam Integer cost) {
        this.productService.addProduct(null,name,cost);
    }


}
