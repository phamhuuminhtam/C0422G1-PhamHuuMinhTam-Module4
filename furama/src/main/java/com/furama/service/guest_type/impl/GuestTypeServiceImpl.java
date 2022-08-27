package com.furama.service.guest_type.impl;

import com.furama.model.GuestType;
import com.furama.repository.GuestTypeRepository;
import com.furama.service.guest_type.GuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestTypeServiceImpl implements GuestTypeService {

    @Autowired
    private GuestTypeRepository guestTypeRepository;
    @Override
    public List<GuestType> findAll() {
        return guestTypeRepository.findAll();
    }
}
