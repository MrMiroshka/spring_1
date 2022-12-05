package ru.miroshka.hibernate;

import org.hibernate.Session;

import java.util.List;

public class ProductDao {


    private Session session = null;


    public Product findById(Long id) {
        session = MainApp.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product productFromProductsDbRead = session.get(Product.class, id);
        System.out.println(productFromProductsDbRead);
        session.getTransaction().commit();
        return productFromProductsDbRead;
    }

    public List<Product> findAll() {
        session = MainApp.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> productFroItemDbRead3 = session.createQuery("SELECT i FROM Product i",Product.class).getResultList();
        System.out.println(productFroItemDbRead3);
        session.getTransaction().commit();
        return productFroItemDbRead3;
    }


    public void deleteById(Long id) {
        session = MainApp.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product productFromDbDelete = session.get(Product.class,id);
        System.out.println(productFromDbDelete);
        session.remove(productFromDbDelete);
        session.getTransaction().commit();
    }

    public Product saveOrUpdate(Product product) {
        session = MainApp.sessionFactory.getCurrentSession();
        session.beginTransaction();

        if (product.getId() == null) {
            session.persist(product);
            System.out.println("Добавили:" + product);
            session.getTransaction().commit();
            return product;
        } else {
            Product productFromProductDbRead = session.get(Product.class, product.getId());
            System.out.println("Изменили объект: " + productFromProductDbRead);
            productFromProductDbRead.setPrice(product.getPrice());
            productFromProductDbRead.setTitle(product.getTitle());
            System.out.println("На объект: " + productFromProductDbRead);
            session.getTransaction().commit();
            return productFromProductDbRead;
        }


    }
}
