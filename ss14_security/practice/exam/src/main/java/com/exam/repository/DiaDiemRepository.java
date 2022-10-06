package com.exam.repository;

import com.exam.model.DiaDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DiaDiemRepository extends JpaRepository<DiaDiem, Integer> {
    @Transactional
    @Query(value = "select * from dia_diem",nativeQuery = true, countQuery = "select count(*) from dia_diem")
    List<DiaDiem> diaDiemList();

    @Transactional
    @Query(value ="select * from dia_diem where id = :id", nativeQuery = true)
    DiaDiem findByID(@Param("id") Integer id);
}
