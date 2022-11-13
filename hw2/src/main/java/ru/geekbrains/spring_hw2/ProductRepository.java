package ru.geekbrains.spring_hw2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepository implements BeanPostProcessor {


    private final List<Product> products;


    private static long idProduct = 1L;

    @Autowired
    public ProductRepository(List<Product> products) {
        this.products = products;
    }


    public List<Product> getProducts() {
        List<Product> copy = new ArrayList<>(this.products);
        this.products.clear();
        return copy;
    }

    public Product getProduct(long id) {
        if (this.products.size() > 0) {
            for (Product pr : this.products) {
                if (pr.getId() == id) {
                    this.products.remove(pr);
                    return pr;
                }
            }
        }
        return null;
    }

    /**
     * при старте ProductRepository  в "List<Product> products"
     * добавляются 5 любых товаров
     */
    @PostConstruct
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
