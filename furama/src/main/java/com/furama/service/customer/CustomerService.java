package com.furama.service.customer;

import com.furama.model.customer.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);
}
