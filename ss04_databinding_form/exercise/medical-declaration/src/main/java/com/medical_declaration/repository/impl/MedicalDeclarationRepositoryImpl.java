package com.medical_declaration.repository.impl;

import com.medical_declaration.model.MedicalDeclaration;
import com.medical_declaration.repository.MedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MedicalDeclarationRepositoryImpl implements MedicalDeclarationRepository {
    private static List<String> yearList = new ArrayList<>();
    private static List<String> dayList = new ArrayList<>();
    private static List<String> monthList = new ArrayList<>();
    private static List<String> genderList = new ArrayList<>();
    private static List<String> nationList = new ArrayList<>();
    private static List<String> vehicleList = new ArrayList<>();
    private static List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();


    static {
        for (int i=1900;i <=LocalDate.now().getYear();i++){
            yearList.add(i+"");
        }
        for (int i=1;i <=31;i++){
            if (i<10)
            dayList.add("0"+i+"");
            else dayList.add(i+"");
        }
        for (int i=1;i <=12;i++){
            if (i<10) monthList.add("0"+i+"");
            else monthList.add(i+"");
        }

        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("Khác");

        nationList.add("Việt Nam");
        nationList.add("Mỹ");
        nationList.add("Anh");
        nationList.add("Trung Quốc");

        vehicleList.add("Tàu bay");
        vehicleList.add("Tàu thuyền");
        vehicleList.add("Ô tô");
        vehicleList.add("Khác (ghi rõ)");
    }

    @Override
    public List<String> findAllYear() {
        return yearList;
    }

    @Override
    public List<String> findAllMonth() {
        return monthList;
    }

    @Override
    public List<String> findAllDay() {
        return dayList;
    }

    @Override
    public List<String> findAllGender() {
        return genderList;
    }

    @Override
    public List<String> findAllNation() {
        return nationList;
    }

    @Override
    public List<String> findAllVehicle() {
        return vehicleList;
    }

    @Override
    public void saveForm(MedicalDeclaration medicalDeclaration) {
        int id = (int) Math.floor(Math.random() * 1000);
        medicalDeclarationList.add(new MedicalDeclaration(id,medicalDeclaration.getName(),medicalDeclaration.getYearOfBirth(),
                medicalDeclaration.getGender(),medicalDeclaration.getNation(),medicalDeclaration.getPersonalCode(),medicalDeclaration.getTransfer(),
                medicalDeclaration.getVehicleCode(),medicalDeclaration.getSeatCode(),medicalDeclaration.getDayOfDateStart(),
                medicalDeclaration.getMonthOfDateStart(),medicalDeclaration.getYearOfDateStart(),medicalDeclaration.getDayOfDateEnd(),
                medicalDeclaration.getMonthOfDateEnd(),medicalDeclaration.getYearOfDateEnd(),medicalDeclaration.getNote()));
    }

    public List<MedicalDeclaration> findAll(){
        return medicalDeclarationList;
    }

    @Override
    public MedicalDeclaration searchById(int id) {
        for (MedicalDeclaration m : medicalDeclarationList){
            if(m.getId()==id)
                return m;
        }
        return null;
    }
//        this.name = name;
//        this.yearOfBirth = yearOfBirth;
//        this.gender = gender;
//        this.nation = nation;
//        this.personalCode = personalCode;
//        this.transfer = transfer;
//        this.vehicleCode = vehicleCode;
//        this.seatCode = seatCode;
//        this.dayOfDateStart = dayOfDateStart;
//        this.monthOfDateStart = monthOfDateStart;
//        this.yearOfDateStart = yearOfDateStart;
//        this.dayOfDateEnd = dayOfDateEnd;
//        this.monthOfDateEnd = monthOfDateEnd;
//        this.yearOfDateEnd = yearOfDateEnd;
//        this.note = note;
    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        for (MedicalDeclaration m : medicalDeclarationList){
            if(m.getId()==id){
                m.setName(medicalDeclaration.getName());
                m.setYearOfBirth(medicalDeclaration.getYearOfBirth());
                m.setGender(medicalDeclaration.getGender());
                m.setNation(medicalDeclaration.getNation());
                m.setPersonalCode(medicalDeclaration.getPersonalCode());
                m.setTransfer(medicalDeclaration.getTransfer());
                m.setVehicleCode(medicalDeclaration.getVehicleCode());
                m.setSeatCode(medicalDeclaration.getSeatCode());
                m.setDayOfDateStart(medicalDeclaration.getDayOfDateStart());
                m.setMonthOfDateStart(medicalDeclaration.getMonthOfDateStart());
                m.setYearOfDateStart(medicalDeclaration.getYearOfDateStart());
                m.setDayOfDateEnd(medicalDeclaration.getDayOfDateEnd());
                m.setMonthOfDateEnd(medicalDeclaration.getMonthOfDateEnd());
                m.setYearOfDateEnd(medicalDeclaration.getYearOfDateEnd());
                m.setNote(medicalDeclaration.getNote());
            }

        }
    }


}
