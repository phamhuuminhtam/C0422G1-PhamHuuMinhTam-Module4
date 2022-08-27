package com.furama.service.rental_type.impl;

import com.furama.model.RentalType;
import com.furama.repository.RentalTypeRepository;
import com.furama.service.rental_type.RentalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentalTypeServiceImpl implements RentalTypeService {
    @Autowired
    private RentalTypeRepository rentalTypeRepository;

    @Override
    public List<RentalType> findAll() {
        return rentalTypeRepository.findAll();
    }
}
