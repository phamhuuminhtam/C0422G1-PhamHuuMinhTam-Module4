package com.furama.service.facility.impl;

import com.furama.model.facility.Facility;
import com.furama.repository.FacilityRepository;
import com.furama.service.facility.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public void delete(Integer id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public List<Facility> search() {
        return facilityRepository.findAll();
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility searchFacility(Integer idSearch) {
        return facilityRepository.findById(idSearch).orElse(null);
    }

    @Override
    public void save(Facility facility) {
        if(facility.getServiceType().getIdServiceType()==1){
            facility.setFreeServiceAdd(null);
        }
        if(facility.getServiceType().getIdServiceType()==2){
            facility.setFreeServiceAdd(null);
            facility.setPoolArea(null);
        }
        if(facility.getServiceType().getIdServiceType()==3){
            facility.setPoolArea(null);
            facility.setRoomStandard(null);
            facility.setNumberOfFloors(null);
            facility.setDescriptionOtherConvenience(null);
        }
        facilityRepository.save(facility);
    }

}
