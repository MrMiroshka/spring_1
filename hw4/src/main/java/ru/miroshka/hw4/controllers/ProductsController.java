package ru.miroshka.hw4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.miroshka.hw4.data.Product;
import ru.miroshka.hw4.services.ProductService;

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
    public void addProduct(@RequestParam Long id,@RequestParam String name, @RequestParam Integer cost) {
        this.productService.addProduct(id,name,cost);
    }


}
