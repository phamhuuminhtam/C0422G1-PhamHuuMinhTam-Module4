package com.sandwich_condiments.repository;

import com.sandwich_condiments.model.Condiment;

import java.util.List;

public interface CondimentRepository {
    List<Condiment> findAll();
}
