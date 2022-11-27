package ru.miroshka.hw4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.miroshka.hw4.data.Product;
import ru.miroshka.hw4.services.ProductService;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    private ProductService productService;


    @GetMapping("/getProduct")
    public String getProduct(Model model, @RequestParam long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }


    @GetMapping("/delete/{id}")
    public void delProductById(@PathVariable Long id) {
        this.productService.delProductById(id);
    }

}
