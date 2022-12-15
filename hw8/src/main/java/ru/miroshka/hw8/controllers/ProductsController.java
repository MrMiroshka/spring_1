package ru.miroshka.hw8.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.miroshka.hw8.data.Product;
import ru.miroshka.hw8.service.ProductService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public List<Product> getProduct(@PathVariable Long id) {

        return this.productService.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.delProductById(id);
    }

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void postProduct(@RequestParam String name, @RequestParam int cost) {
        this.productService.addProduct(name, cost);
    }

    @GetMapping("/getAllProducts")
    public Page<Product> getProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
       // return this.productService.getProducts();
        return this.productService.getProducts(page);
    }


    private List<Product> productsIterableToList(Iterable<Product> products) {
        List<Product> productsList = new ArrayList<>();
        for (Product p : products) {
            productsList.add(p);
        }
        return productsList;
    }


}
