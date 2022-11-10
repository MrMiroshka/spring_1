package ru.geekbrains.spring_hw2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.spring_hw2");
        ProductRepository productRepository =context.getBean(ProductRepository.class) ;

        context.getBeanFactory();
        productRepository.getProducts();
        Cart cart = context.getBean(Cart.class);
        cart.putProducts(productRepository.getProduct(2));
        cart.putProducts(productRepository.getProduct(3));
        cart.printToConsole();
        cart.delProduct(2);
        cart.printToConsole();
        Cart cart2 = context.getBean(Cart.class);
        cart.putProducts(productRepository.getProduct(9));
        cart.putProducts(productRepository.getProduct(1));
        cart2.printToConsole();
    }
}
