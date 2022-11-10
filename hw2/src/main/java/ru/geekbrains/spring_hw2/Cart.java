package ru.geekbrains.spring_hw2;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Builder
@Lazy
@Scope("prototype")
@Component
public class Cart {
    private final ArrayList<Product> products;

    public Cart(ArrayList<Product> products) {
        this.products = products;
    }

    public Product delProduct(long id) {
        for (Product pr : this.products) {
            if (pr.getId() == id) {
                this.products.remove(pr);
                return pr;
            }
        }
        return null;
    }

    public void putProducts(Product pR) {
        if (pR != null) {
            this.products.add(pR);
        }
    }

    public void printToConsole() {
        System.out.println("В корзине находятся:");
        if (!this.products.isEmpty()) {
            for (Product pr : this.products) {
                System.out.println(pr.getTitle());
            }
        }else{
            System.out.println("В корзине нет продуктов");
        }
    }
}
