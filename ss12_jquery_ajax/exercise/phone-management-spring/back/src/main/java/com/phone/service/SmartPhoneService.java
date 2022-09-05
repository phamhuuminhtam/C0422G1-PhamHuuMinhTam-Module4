package com.phone.service;

import com.phone.model.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    void save(SmartPhone smartPhone);
    List<SmartPhone> findAll();
    void deleteById(Long id);
    SmartPhone findById(Long id);
}
