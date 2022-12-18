package ru.miroshka.hw9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.miroshka.hw9.data.Product;
import ru.miroshka.hw9.repositories.ProductDao;


@Component
public class DatabaseFilter {
    @Autowired
    private ProductDao productDao;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartApplication(){
        productDao.save(createProduct("Milk",10));
        productDao.save(createProduct("Eggs",20));
        productDao.save(createProduct("Meat",30));
        productDao.save(createProduct("Cake",40));
        productDao.save(createProduct("Cookie",50));
        productDao.save(createProduct("Fish",60));
        productDao.save(createProduct("Flake",70));
        productDao.save(createProduct("Juice",80));
        productDao.save(createProduct("Glue",90));
        productDao.save(createProduct("Cards",100));
        productDao.save(createProduct("Paints",110));
        productDao.save(createProduct("Brushes ",120));
        productDao.save(createProduct("Files",130));
        productDao.save(createProduct("Paper",140));
        productDao.save(createProduct("Notepad",150));
        productDao.save(createProduct("Salmon",160));
        productDao.save(createProduct("Sausage",170));
        productDao.save(createProduct("Yoghurt",180));
        productDao.save(createProduct("Braclet",190));
        productDao.save(createProduct("Ring",200));

    }

    private Product createProduct (String name, int cost){
        Product product = new Product();
        product.setName(name);
        product.setCost(cost);
        return product;
    }
}
