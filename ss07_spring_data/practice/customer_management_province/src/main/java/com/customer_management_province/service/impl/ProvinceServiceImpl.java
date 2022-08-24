package com.customer_management_province.service.impl;

import com.customer_management_province.model.Province;
import com.customer_management_province.repository.ProvinceRepository;
import com.customer_management_province.service.GeneralService;
import com.customer_management_province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService<Province> {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {

        return provinceRepository.findById(id).orElse(null);

    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.findById(id);
    }
}
