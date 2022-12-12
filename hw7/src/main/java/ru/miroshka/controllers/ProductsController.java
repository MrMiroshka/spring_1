package ru.miroshka.controllers;


import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.miroshka.data.Product;
import ru.miroshka.repositories.ProductDao;

import java.util.ArrayList;
import java.util.List;
//import ru.miroshka.hw7.service.ProductService;



@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductDao productDao;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return  productDao.findById(id).orElseThrow(() ->
                new NoResultException("Товар с указанным id (" + id + ") не существует!"));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productDao.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postProduct(@RequestBody Product product) {
        productDao.save(product);
    }

    @GetMapping
    public List<Product> getProducts(){
        Iterable<Product> products = productDao.findAll();

        List<Product> productsList = new ArrayList<>();
        for (Product p: products) {
           productsList.add(p);
        }
        return productsList;
    }

    @GetMapping("/min<{cost}")
    public List<Product> getProductsGreaterMin(@PathVariable int cost){
        return productsIterableToList(productDao.findByCostGreaterThan(cost));
    }

    @GetMapping("/between/min={min}/max={max}")
    public List<Product>getProductsBetween(@PathVariable int min,@PathVariable int max){
        return productsIterableToList(productDao.findByCostBetween(min,max));
    }


    @GetMapping("/max>{cost}")
    public List<Product>  getProductsLessMax (@PathVariable int cost){
        return productsIterableToList(productDao.findByCostLessThan(cost));
    }

    private List<Product> productsIterableToList(Iterable<Product> products){
        List<Product> productsList = new ArrayList<>();
        for (Product p: products) {
            productsList.add(p);
        }
        return productsList;
    }


}
