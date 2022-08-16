package com.sandwich_condiments.service.impl;

import com.sandwich_condiments.model.Condiment;
import com.sandwich_condiments.repository.CondimentRepository;
import com.sandwich_condiments.service.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CondimentServiceImpl implements CondimentService {
    @Autowired
    private CondimentRepository condimentRepository;
    @Override
    public List<Condiment> findAll() {
        return condimentRepository.findAll();
    }
}
