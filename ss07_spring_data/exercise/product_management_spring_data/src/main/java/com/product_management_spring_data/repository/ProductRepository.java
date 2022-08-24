package com.product_management_spring_data.repository;


import com.product_management_spring_data.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}
