package com.furama.service.attachfacility.impl;

import com.furama.model.AttachFacility;
import com.furama.repository.AttachFacilityRepository;
import com.furama.service.attachfacility.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityServiceImpl implements AttachFacilityService {
    @Autowired
    private AttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
