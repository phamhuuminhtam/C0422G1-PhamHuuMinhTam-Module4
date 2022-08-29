package com.furama.service.customer.impl;

import com.furama.model.customer.Customer;
import com.furama.repository.CustomerRepository;
import com.furama.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> findAll(String keyWord, Pageable pageable) {
        return customerRepository.findAllByNameContainingOrPersonalCodeContainingOrPhoneNumberContainingOrEmailContainingOrGuestType_GuestTypeNameContaining(keyWord,keyWord,keyWord,keyWord,keyWord, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
