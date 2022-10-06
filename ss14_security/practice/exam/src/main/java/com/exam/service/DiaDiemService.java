package com.exam.service;

import com.exam.model.DiaDiem;

import java.util.List;

public interface DiaDiemService {
   List<DiaDiem> findAll();
   DiaDiem findById(Integer id);
}
