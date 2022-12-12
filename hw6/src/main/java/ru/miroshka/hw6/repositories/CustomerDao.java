package ru.miroshka.hw6.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.miroshka.hw6.SessionFactoryUtil;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Product;

import java.util.List;

@Component
public class CustomerDao implements BeanPostProcessor {
    private SessionFactoryUtil sessionFactoryUtil;

    public CustomerDao(SessionFactoryUtil sessionFactoryUtil) {

        this.sessionFactoryUtil = sessionFactoryUtil;
    }

    public List<Customer> getCustomers() {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        List<Customer> customerFroItemDbRead3 = session.createQuery("SELECT i FROM Customer i", Customer.class).getResultList();
        System.out.println(customerFroItemDbRead3);
        session.getTransaction().commit();
        return customerFroItemDbRead3;
    }

    public Customer getCustomer(Long id) {
        Session session = sessionFactoryUtil.getSession();
        session.beginTransaction();
        Customer customerFromProductsDbRead = session.get(Customer.class, id);
        System.out.println(customerFromProductsDbRead);
        session.getTransaction().commit();
        return customerFromProductsDbRead;
    }
}
