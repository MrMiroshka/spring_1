package ru.miroshka.hw6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.miroshka.hw6.controllers.CustomerController;
import ru.miroshka.hw6.controllers.OrderProductController;
import ru.miroshka.hw6.controllers.ProductsController;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Order;
import ru.miroshka.hw6.data.Product;
import org.hibernate.SessionFactory;


public class MainApp {
    public static SessionFactory sessionFactory;

    private static void printOrder(Order p) {
        System.out.println();
        System.out.printf("id пользователя - %d, name пользователя - %s, цена товара на момент покупки - %d",
                p.getCustomer().getId(), p.getCustomer().getName(), p.getCost() / p.getCount());
        System.out.println();
        System.out.println("Время покупки - " + p.getDateTime());
        System.out.printf("id продукта - %d, name продукта - %s, cost на данный момент - %d", p.getProduct().getId(),
                p.getProduct().getName(), p.getProduct().getCost());
        System.out.println();
    }

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.miroshka.hw6");
        OrderProductController orderProductController = context.getBean(OrderProductController.class);
        ProductsController productController = context.getBean(ProductsController.class);
        CustomerController customerController = context.getBean(CustomerController.class);


        System.out.println("Найдем все продукты пользователя - " + (customerController.getCustomer(1L)).get(0).getName());
        for (Product p : orderProductController.getProducts(1L)) {
            System.out.println();
            System.out.printf("id - %d, name - %s, cost - %d", p.getId(), p.getName(), p.getCost());
        }
        System.out.println();


        System.out.println("Найдем всех пользователей- " + (productController.getProduct(2L)).get(0).getName());
        for (Customer C : orderProductController.getCustomers(2L)) {
            System.out.println();
            System.out.printf("id - %d, name - %s,", C.getId(), C.getName());
        }

        System.out.println();


        System.out.println("Запросим полные данные");

        System.out.println("Найдем всю инфу, зная пользователя - " + (customerController.getCustomer(1L)).get(0).getName());
        for (Order p : orderProductController.getProductsFullInfo(1L)) {
            printOrder(p);
        }
        System.out.println();


        System.out.println("Найдем всю инфу, зная продукт - " + (productController.getProduct(2L)).get(0).getName());
        for (Order p : orderProductController.getCustomersFullInfo(2L)) {
            printOrder(p);
        }

        SessionFactoryUtil sf = context.getBean(SessionFactoryUtil.class);
        sf.getSessionFactory().close();
    }
}
