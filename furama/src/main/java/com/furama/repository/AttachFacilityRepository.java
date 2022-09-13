package com.furama.repository;

import com.furama.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    List<AttachFacility> findAll();
}
