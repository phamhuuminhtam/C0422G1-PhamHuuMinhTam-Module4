package com.module4.service;

import com.module4.model.GiaoDich;
import com.module4.repository.GiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GiaoDichServiceImpl implements GiaoDichService {

    @Autowired
    private GiaoDichRepository giaoDichRepository;
    @Override
    public List<GiaoDich> findAllByTypeService_IdAndAndCustomer_Name(Integer id, String name) {
        return giaoDichRepository.findAllByTypeService_IdAndAndCustomer_Name(id, name);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public GiaoDich findById(String id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public List<GiaoDich> findAll() {
        return giaoDichRepository.findAll();
    }
}
