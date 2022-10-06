package com.module4.repository;

import com.module4.model.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {

    List<GiaoDich> findAllByTypeService_IdAndAndCustomer_Name(Integer id, String name);

}
