package ru.miroshka.hibernate.zadanie_1_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.miroshka.hibernate.User;
import ru.miroshka.hibernate.UserDetails;

import java.util.List;


public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .buildSessionFactory();

        Session session = null;
        session = sessionFactory.getCurrentSession();

        //create
        session.beginTransaction();
        Item item = new Item("Milk",80);
        System.out.println(item);
        session.persist(item);
        session.getTransaction().commit();


        //read - достать объект из базы
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.get(Item.class,1L);
        System.out.println(itemFromDb);
        session.getTransaction().commit();

        //read 2 - достать объект из базы
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFroItemDbRead2 = session.createQuery("SELECT i FROM Item i WHERE i.id=:id",Item.class)
                .setParameter("id",4L)
                .getSingleResult();
        System.out.println(itemFroItemDbRead2);
        session.getTransaction().commit();


        //read 3 - достать объекты из базы
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Item> itemFroItemDbRead3 = session.createQuery("SELECT i FROM Item i",Item.class).getResultList();
        System.out.println(itemFroItemDbRead3);
        session.getTransaction().commit();

        //update
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDbUpdate = session.get(Item.class,1L);
        System.out.println(itemFromDbUpdate);
        itemFromDbUpdate.setPrice(200);
        session.getTransaction().commit();


        //delete
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDbDelete = session.get(Item.class,1L);
        System.out.println(itemFromDbDelete);
        session.remove(itemFromDbDelete);
        session.getTransaction().commit();

        //добавили несколько классов - таблиц
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class,1L);
        System.out.println(user);
        System.out.println(user.getDetails());
        System.out.println(user.getDetails().getUser());
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
