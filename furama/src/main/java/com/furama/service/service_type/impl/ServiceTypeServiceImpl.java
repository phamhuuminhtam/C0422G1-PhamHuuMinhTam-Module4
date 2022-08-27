package com.furama.service.service_type.impl;

import com.furama.model.ServiceType;
import com.furama.repository.ServiceRepository;
import com.furama.service.service_type.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceRepository.findAll();
    }
}
