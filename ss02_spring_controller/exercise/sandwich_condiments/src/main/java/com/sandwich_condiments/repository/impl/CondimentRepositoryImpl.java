package com.sandwich_condiments.repository.impl;

import com.sandwich_condiments.model.Condiment;
import com.sandwich_condiments.repository.CondimentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentRepositoryImpl implements CondimentRepository {
    private static List<Condiment> condimentList = new ArrayList<>();

    static {
        condimentList.add(new Condiment(1, "Lettuce"));
        condimentList.add(new Condiment(2, "Tomato"));
        condimentList.add(new Condiment(3, "Mustard"));
        condimentList.add(new Condiment(4, "Sprouts"));
    }

    @Override
    public List<Condiment> findAll() {
        return condimentList;
    }
}
