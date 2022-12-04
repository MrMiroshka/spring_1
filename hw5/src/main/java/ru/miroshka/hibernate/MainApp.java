package ru.miroshka.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp
{
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory= new Configuration()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        ProductDao pD = new ProductDao();


        Product p = pD.findById(4L);
        System.out.println("найдем продукт с id  = 4");
        System.out.println(p);

        p = pD.findById(444L);
        System.out.println("найдем продукт с id  = 444");
        System.out.println(p);

        p = new Product( "Egs" ,400);
        pD.saveOrUpdate(p);
        System.out.println("Добавили новый объект");
        System.out.println(p);


        System.out.println("Обновим объект" + p);
        p.setPrice(1000);
        pD.saveOrUpdate(p);
        System.out.println(p);

        System.out.println("Получим весь список продуктов:");
        for (Product tempProduct:pD.findAll() ) {
            System.out.println(tempProduct);
        }


        System.out.println("Удалим продукт с id = " + p.getId());
        pD.deleteById(p.getId());
        System.out.println("Распечатаем весь список продуктов:");
        for (Product tempProduct:pD.findAll() ) {
            System.out.println(tempProduct);
        }

        sessionFactory.close();
    }
}
