package com.furama.repository;

import com.furama.model.contract.Contract;
import com.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByNameContainingOrPersonalCodeContainingOrPhoneNumberContainingOrEmailContainingOrGuestType_GuestTypeNameContaining(String keyWord1, String keyWord2,String keyWord3,String keyWord4,String keyWord5,Pageable pageable);

   }
