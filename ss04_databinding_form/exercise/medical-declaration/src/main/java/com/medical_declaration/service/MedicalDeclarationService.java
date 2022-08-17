package com.medical_declaration.service;

import com.medical_declaration.model.MedicalDeclaration;

import java.util.List;

public interface MedicalDeclarationService {
    List<String> findAllYear();
    List<String> findAllMonth();
    List<String> findAllDay();
    List<String> findAllGender();
    List<String> findAllNation();
    List<String> findAllVehicle();
    void saveForm(MedicalDeclaration medicalDeclaration);
    List<MedicalDeclaration> findAll();
    MedicalDeclaration searchById(int id);
    void update(int id, MedicalDeclaration medicalDeclaration);
}
