package ru.miroshka.hw6.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import ru.miroshka.hw6.SessionFactoryUtil;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Order;
import ru.miroshka.hw6.data.Product;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;


@Component
public class ProductDao implements BeanPostProcessor {

    private SessionFactoryUtil sessionFactoryUtil;

    public ProductDao(SessionFactoryUtil sessionFactoryUtil) {
        this.sessionFactoryUtil = sessionFactoryUtil;
    }


    public void delProductById(Long id) {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        Product productFromDbDelete = session.get(Product.class, id);
        System.out.println(productFromDbDelete);
        session.remove(productFromDbDelete);
        session.getTransaction().commit();
    }

    public List<Product> getProducts() {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        List<Product> productFroItemDbRead3 = session.createQuery("SELECT i FROM Product i", Product.class).getResultList();
        System.out.println(productFroItemDbRead3);
        session.getTransaction().commit();
        return productFroItemDbRead3;
    }

    public Product getProduct(Long id) {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        Product productFromProductsDbRead = session.get(Product.class, id);
        System.out.println(productFromProductsDbRead);
        session.getTransaction().commit();
        return productFromProductsDbRead;
    }


    public Product saveOrUpdate(Product product) {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();

        if (product.getId() == null || product.getId() == -1) {
            session.persist(product);
            System.out.println("Добавили:" + product);
            session.getTransaction().commit();
            return product;
        } else {
            Product productFromProductDbRead = session.get(Product.class, product.getId());
            System.out.println("Изменили объект: " + productFromProductDbRead);
            productFromProductDbRead.setCost(product.getCost());
            productFromProductDbRead.setName(product.getName());
            System.out.println("На объект: " + productFromProductDbRead);
            session.getTransaction().commit();
            return productFromProductDbRead;
        }


    }
}
