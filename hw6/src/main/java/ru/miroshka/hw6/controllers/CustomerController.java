package ru.miroshka.hw6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Product;
import ru.miroshka.hw6.service.CustomerService;
import ru.miroshka.hw6.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public List<Customer> getProduct(Long id) {
        List<Customer> m = new ArrayList<>();
        m.add(customerService.getCustomer(id));
        return m;
    }

    public List<Customer> getAllProducts() {
        return customerService.getCustomers();
    }


}
