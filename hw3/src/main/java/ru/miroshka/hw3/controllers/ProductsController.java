package ru.miroshka.hw3.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.miroshka.hw3.model.Product;
import ru.miroshka.hw3.model.ProductRepository;

import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    ProductRepository pR;





    @GetMapping("/getProduct")
    public String getProduct(Model model, @RequestParam long id){
        model.addAttribute("product",pR.getProduct(id));
        return "product";
    }

    @GetMapping("/getAllProducts")
    public String getAllProducts(Model model){
        model.addAttribute("productList",(List) pR.getProducts());
        model.addAttribute("product",  Product.builder().id(0).title("0").cost(0).build());
        return "products";
    }


    @PostMapping("/getAllProducts")
    public String greetingSubmit(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        model.addAttribute("productList",(List) pR.getProducts());
        pR.setProduct(product);
        return "products";
    }

}
