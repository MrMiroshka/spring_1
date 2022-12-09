package ru.miroshka.hw6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Order;
import ru.miroshka.hw6.data.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderProductController {
    @Autowired
    private ru.miroshka.hw6.service.OrderProductService orderProductService;
    private ru.miroshka.hw6.service.ProductService productService;
    private ru.miroshka.hw6.service.CustomerService customerService;

    public List<Customer> getCustomers(Long id) {
        List<Customer> listC= new ArrayList<Customer>();
        for (Order o:orderProductService.getCustomers(id)) {
            listC.add(o.getCustomer());
        }

        return listC;
    }

    public List<Product> getProducts(Long id) {

        List<Product> listP= new ArrayList<Product>();
        for (Order o:orderProductService.getCustomers(id)) {
            listP.add(o.getProduct());
        }
        return listP;
    }


}

