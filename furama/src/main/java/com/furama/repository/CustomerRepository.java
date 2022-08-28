package com.furama.repository;

import com.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByNameContainingOrPersonalCodeContainingOrPhoneNumberContainingOrEmailContaining(String keyWord1, String keyWord2,String keyWord3,String keyWord4,Pageable pageable);
}
