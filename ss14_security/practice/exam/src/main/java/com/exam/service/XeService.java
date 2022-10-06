package com.exam.service;

import com.exam.model.Xe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface XeService {
   Page<Xe> findAll(Pageable pageable,String key);
   void delete(Integer id);
   Xe findById(Integer id);
   void add(Xe xe);
   void edit(Xe xe);
}
