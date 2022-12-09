package ru.miroshka.hw6.repositories;
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
public class OrderProductDao implements BeanPostProcessor {

    private SessionFactoryUtil sessionFactoryUtil;

    public OrderProductDao(SessionFactoryUtil sessionFactoryUtil) {
        this.sessionFactoryUtil = sessionFactoryUtil;
    }

    public List<Order> getCustomers(Long id) {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        List<Order> customerFroItemDbRead3 = session.createQuery("SELECT i FROM Order i WHERE i.customer=:id", Order.class)
                .setParameter("id",id)
                .getResultList();
        System.out.println(customerFroItemDbRead3);
        session.getTransaction().commit();
        return customerFroItemDbRead3;
    }

    public List<Order> getProducts(Long id) {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        List<Order> productFroItemDbRead3 = session.createQuery("SELECT i FROM Order i WHERE i.product=:id", Order.class)
                .setParameter("id",id)
                .getResultList();
        System.out.println(productFroItemDbRead3);
        session.getTransaction().commit();
        return productFroItemDbRead3;
    }

}
