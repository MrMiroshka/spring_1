package ru.miroshka.hw6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.miroshka.hw6.controllers.CustomerController;
import ru.miroshka.hw6.controllers.OrderProductController;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Order;
import ru.miroshka.hw6.data.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.miroshka.hw6.repositories.ProductDao;


public class MainApp {
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.miroshka.hw6");
        OrderProductController OrderProductController = context.getBean(OrderProductController.class);
        System.out.println(OrderProductController.getProducts(1L));
        System.out.println(OrderProductController.getCustomers(2L));


        SessionFactoryUtil sf = context.getBean(SessionFactoryUtil.class);
        sf.getSessionFactory().close();
    }
}
