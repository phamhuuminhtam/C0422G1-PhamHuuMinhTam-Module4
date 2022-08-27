package com.furama.repository;

import com.furama.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility,Integer> {
}
