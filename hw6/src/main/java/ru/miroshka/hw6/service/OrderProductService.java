package ru.miroshka.hw6.service;

import org.springframework.stereotype.Service;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Order;
import ru.miroshka.hw6.data.Product;
import ru.miroshka.hw6.repositories.OrderProductDao;


import java.util.List;

@Service
public class OrderProductService {
    private ru.miroshka.hw6.repositories.OrderProductDao OrderProductDao;

    public OrderProductService(OrderProductDao OrderProductDao) {
        this.OrderProductDao = OrderProductDao;
    }

    public List<Order> getCustomers(Long id) {
        return this.OrderProductDao.getCustomers(id);
    }

    public List<Order> getProducts(Long id) {
        return this.OrderProductDao.getProducts(id);
    }


}
