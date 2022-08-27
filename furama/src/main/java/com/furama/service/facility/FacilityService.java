package com.furama.service.facility;


import com.furama.model.facility.Facility;

import java.util.List;

public interface FacilityService {
    void delete(Integer id);

    List<Facility> search();

    List<Facility> findAll();

    Facility searchFacility(Integer idSearch);

    void save(Facility facility);
}
