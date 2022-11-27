package ru.miroshka.hw4.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.miroshka.hw4.data.DictionaryProductsName;
import ru.miroshka.hw4.data.Product;

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

    public void delProductById(Long id){
        products.removeIf(p->p.getId().equals(id));
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(Long id) {
        return
                this.products.stream()
                        .filter(p -> Objects.equals(id, p.getId()))
                        .findFirst()
                        .orElse(null);
    }

    /**
     * для теста (как будто взяли из базы)
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


    public void addProduct(Long id, String name, Integer cost) {
        Product product = Product.builder().id(id).title(name).cost(cost).build();
        if (null == this.products.stream()
                .filter(p -> Objects.equals(product.getId(), p.getId()))
                .findFirst()
                .orElse(null)) {
            this.products.add(product);
        }
    }
}
