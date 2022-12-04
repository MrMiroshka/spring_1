package ru.miroshka.hibernate.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import ru.miroshka.hibernate.data.Product;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;


@Component
public class ProductDao implements BeanPostProcessor {


    public static SessionFactory sessionFactory= new Configuration()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

    private Session session = null;

    private final List<Product> products;


    private static long idProduct = 1L;


    public ProductDao(List<Product> products) {
        this.products = products;
    }

    public void setProduct(Product product) {
        if (null == this.products.stream()
                .filter(p -> Objects.equals(product.getId(), p.getId()))
                .findFirst()
                .orElse(null)) {
            this.products.add(product);
        }
    }

    public void delProductById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product productFromDbDelete = session.get(Product.class,id);
        System.out.println(productFromDbDelete);
        session.remove(productFromDbDelete);
        session.getTransaction().commit();
    }

    public List<Product> getProducts() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> productFroItemDbRead3 = session.createQuery("SELECT i FROM Product i", Product.class).getResultList();
        System.out.println(productFroItemDbRead3);
        session.getTransaction().commit();
        return productFroItemDbRead3;
    }

    public Product getProduct(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product productFromProductsDbRead = session.get(Product.class, id);
        System.out.println(productFromProductsDbRead);
        session.getTransaction().commit();
        return productFromProductsDbRead;
    }



    public Product saveOrUpdate(Product product) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        if (product.getId() == null || product.getId()==-1) {
            session.persist(product);
            System.out.println("Добавили:" + product);
            session.getTransaction().commit();
            return product;
        } else {
            Product productFromProductDbRead = session.get(Product.class, product.getId());
            System.out.println("Изменили объект: " + productFromProductDbRead);
            productFromProductDbRead.setCost(product.getCost());
            productFromProductDbRead.setTitle(product.getTitle());
            System.out.println("На объект: " + productFromProductDbRead);
            session.getTransaction().commit();
            return productFromProductDbRead;
        }


    }
}
