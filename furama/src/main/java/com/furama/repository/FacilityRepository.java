package com.furama.repository;

import com.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility> findAllByServiceNameContainingOrServiceType_ServiceTypeNameContainingOrDescriptionOtherConvenienceContaining(String keyWord1,String keyWord2,String keyWord3,Pageable pageable);
}
