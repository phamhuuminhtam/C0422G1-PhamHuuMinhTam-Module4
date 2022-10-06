package com.exam.service;

import com.exam.model.DiaDiem;
import com.exam.repository.DiaDiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaDiemServiceImpl implements DiaDiemService{
    @Autowired
    private DiaDiemRepository diaDiemRepository;

    @Override
    public List<DiaDiem> findAll() {
        return diaDiemRepository.diaDiemList();
    }

    @Override
    public DiaDiem findById(Integer id) {
        return diaDiemRepository.findByID(id);
    }
}
