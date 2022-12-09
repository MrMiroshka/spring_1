package ru.miroshka.hw6.service;

import org.springframework.stereotype.Service;
import ru.miroshka.hw6.data.Customer;
import ru.miroshka.hw6.data.Product;
import ru.miroshka.hw6.repositories.CustomerDao;
import ru.miroshka.hw6.repositories.ProductDao;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDao customertDao;

    public CustomerService(CustomerDao customerDao) {
        this.customertDao = customerDao;
    }

    public List<Customer> getCustomers() {
        return this.customertDao.getCustomers();
    }

    public Customer getCustomer(Long id) {
        return this.customertDao.getCustomer(id);
    }


}


