package ru.miroshka.hw3.model;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
public class ProductRepository implements BeanPostProcessor {


    private final List<Product> products;


    private static long idProduct = 1L;


    public ProductRepository(List<Product> products) {
        this.products = products;
        this.init();
    }

    public void setProduct(Product product) {
        if (null == this.products.stream()
                .filter(p -> Objects.equals(product.getId(), p.getId()))
                .findFirst()
                .orElse(null)) {
            this.products.add(product);
        }
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(long id) {
        return
                this.products.stream()
                        .filter(p -> Objects.equals(id, p.getId()))
                        .findFirst()
                        .orElse(null);
    }

    /**
     * для теста (как будто взяли из базы)
     */
    public void init() {
        for (int i = 0; i < 5; i++) {
            this.products.add(Product.builder()
                    .id(idProduct++)
                    .title(DictionaryProductsName.values()[new Random().nextInt(
                            DictionaryProductsName.values().length - 1)].getTitle())
                    .cost(1 + (int) (new Random().nextFloat() * (200)))
                    .build());
        }

    }


}
