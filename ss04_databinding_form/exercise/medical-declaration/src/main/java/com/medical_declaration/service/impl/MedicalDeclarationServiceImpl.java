package com.medical_declaration.service.impl;

import com.medical_declaration.model.MedicalDeclaration;
import com.medical_declaration.repository.MedicalDeclarationRepository;
import com.medical_declaration.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationServiceImpl implements MedicalDeclarationService {

    @Autowired
    private MedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public List<String> findAllYear() {
        return medicalDeclarationRepository.findAllYear();
    }

    @Override
    public List<String> findAllMonth() {
        return medicalDeclarationRepository.findAllMonth();
    }

    @Override
    public List<String> findAllDay() {
        return medicalDeclarationRepository.findAllDay();
    }

    @Override
    public List<String> findAllGender() {
        return medicalDeclarationRepository.findAllGender();
    }

    @Override
    public List<String> findAllNation() {
        return medicalDeclarationRepository.findAllNation();
    }

    @Override
    public List<String> findAllVehicle() {
        return medicalDeclarationRepository.findAllVehicle();
    }

    @Override
    public void saveForm(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.saveForm(medicalDeclaration);
    }

    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationRepository.findAll();
    }

    @Override
    public MedicalDeclaration searchById(int id) {
        return medicalDeclarationRepository.searchById(id);
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.update(id,medicalDeclaration);
    }
}
