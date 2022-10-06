package com.exam.service;

import com.exam.model.Xe;
import com.exam.repository.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class XeServiceImpl implements XeService{
    @Autowired
    private XeRepository xeRepository;
    @Override
    public Page<Xe> findAll(Pageable pageable,String key) {
        return xeRepository.xePage(pageable,"%" + key + "%");
    }

    @Override
    public void delete(Integer id) {
        xeRepository.delete(id);
    }

    @Override
    public Xe findById(Integer id) {
        return xeRepository.findByID(id);
    }

    @Override
    public void add(Xe xe) {
        xeRepository.add(xe.getBienSo(), xe.getEmail(),xe.getGioDen(), xe.getGioKhoiHanh(),xe.getLoaiXe(),xe.getSoDienThoai(),xe.getTenNhaXe(),xe.getDiemDen().getId(),xe.getDiemDi().getId());
    }

    @Override
    public void edit(Xe xe) {
        xeRepository.edit(xe.getBienSo(), xe.getEmail(),xe.getGioDen(), xe.getGioKhoiHanh(),xe.getLoaiXe(),xe.getSoDienThoai(),xe.getTenNhaXe(),xe.getDiemDen().getId(),xe.getDiemDi().getId(),xe.getId());
    }
}
