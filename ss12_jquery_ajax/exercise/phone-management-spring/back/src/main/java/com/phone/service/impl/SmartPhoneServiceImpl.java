package com.phone.service.impl;

import com.phone.model.SmartPhone;
import com.phone.repository.SmartPhoneRepository;
import com.phone.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SmartPhoneServiceImpl implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    @Override
    public void save(SmartPhone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public SmartPhone findById(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }
}
