package com.furama.service.customer;

import com.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {

    Page<Customer> findAll(String keyWord, Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);

    List<Customer> findCustomerList();
}
