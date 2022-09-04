package com.furama.service.facility;


import com.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacilityService {
    void delete(Integer id);

    List<Facility> search();

    Page<Facility> findAll(Pageable pageable, String keyWord);

    Facility searchFacility(Integer idSearch);

    void save(Facility facility);
}
