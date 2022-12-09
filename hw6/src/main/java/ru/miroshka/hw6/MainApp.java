package ru.miroshka.hw6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.miroshka.hw6.controllers.CustomerController;
import ru.miroshka.hw6.controllers.OrderProductController;
import ru.miroshka.hw6.controllers.ProductsController;
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
        OrderProductController orderProductController = context.getBean(OrderProductController.class);
        ProductsController productController = context.getBean(ProductsController.class);
        CustomerController customerController = context.getBean(CustomerController.class);



        System.out.println("Найдем все продукты пользователя - " + (productController.getProduct(1L)).get(0).getName());
        for (Product p:   orderProductController.getProducts(1L)    ) {
            System.out.println();
            System.out.printf("id - %d, name - %s, cost - %d",p.getId(),p.getName(),p.getCost());
        }
        System.out.println();


        System.out.println("Найдем всех пользователей- " + (customerController.getCustomer(2L)).get(0).getName());
        for (Customer C:   orderProductController.getCustomers(2L)    ) {
            System.out.println();
            System.out.printf("id - %d, name - %s,",C.getId(),C.getName());
        }

        System.out.println();
        SessionFactoryUtil sf = context.getBean(SessionFactoryUtil.class);
        sf.getSessionFactory().close();
    }
}
