package com.module4.service;

import com.module4.model.GiaoDich;

import java.util.List;

public interface GiaoDichService {
    List<GiaoDich> findAllByTypeService_IdAndAndCustomer_Name(Integer id, String name);

    void save(GiaoDich giaoDich);

    GiaoDich findById(String id);

    void delete(String id);

    List<GiaoDich> findAll();
}
