package com.medical_declaration.model;

public class MedicalDeclaration {
    private int id;
    private String name;
    private String yearOfBirth;
    private String gender;
    private String nation;
    private String personalCode;
    private String transfer;
    private String vehicleCode;
    private String seatCode;
    private String dayOfDateStart;
    private String monthOfDateStart;
    private String yearOfDateStart;
    private String dayOfDateEnd;
    private String monthOfDateEnd;
    private String yearOfDateEnd;
    private String note;

    public MedicalDeclaration(int id, String name, String yearOfBirth, String gender, String nation,
                              String personalCode, String transfer, String vehicleCode, String seatCode,
                              String dayOfDateStart, String monthOfDateStart, String yearOfDateStart, String dayOfDateEnd,
                              String monthOfDateEnd, String yearOfDateEnd, String note) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nation = nation;
        this.personalCode = personalCode;
        this.transfer = transfer;
        this.vehicleCode = vehicleCode;
        this.seatCode = seatCode;
        this.dayOfDateStart = dayOfDateStart;
        this.monthOfDateStart = monthOfDateStart;
        this.yearOfDateStart = yearOfDateStart;
        this.dayOfDateEnd = dayOfDateEnd;
        this.monthOfDateEnd = monthOfDateEnd;
        this.yearOfDateEnd = yearOfDateEnd;
        this.note = note;
    }

    public MedicalDeclaration(String name, String yearOfBirth, String gender, String nation, String personalCode,
                              String transfer, String vehicleCode, String seatCode, String dayOfDateStart,
                              String monthOfDateStart, String yearOfDateStart, String dayOfDateEnd, String monthOfDateEnd,
                              String yearOfDateEnd, String note) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nation = nation;
        this.personalCode = personalCode;
        this.transfer = transfer;
        this.vehicleCode = vehicleCode;
        this.seatCode = seatCode;
        this.dayOfDateStart = dayOfDateStart;
        this.monthOfDateStart = monthOfDateStart;
        this.yearOfDateStart = yearOfDateStart;
        this.dayOfDateEnd = dayOfDateEnd;
        this.monthOfDateEnd = monthOfDateEnd;
        this.yearOfDateEnd = yearOfDateEnd;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicalDeclaration() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getDayOfDateStart() {
        return dayOfDateStart;
    }

    public void setDayOfDateStart(String dayOfDateStart) {
        this.dayOfDateStart = dayOfDateStart;
    }

    public String getMonthOfDateStart() {
        return monthOfDateStart;
    }

    public void setMonthOfDateStart(String monthOfDateStart) {
        this.monthOfDateStart = monthOfDateStart;
    }

    public String getYearOfDateStart() {
        return yearOfDateStart;
    }

    public void setYearOfDateStart(String yearOfDateStart) {
        this.yearOfDateStart = yearOfDateStart;
    }

    public String getDayOfDateEnd() {
        return dayOfDateEnd;
    }

    public void setDayOfDateEnd(String dayOfDateEnd) {
        this.dayOfDateEnd = dayOfDateEnd;
    }

    public String getMonthOfDateEnd() {
        return monthOfDateEnd;
    }

    public void setMonthOfDateEnd(String monthOfDateEnd) {
        this.monthOfDateEnd = monthOfDateEnd;
    }

    public String getYearOfDateEnd() {
        return yearOfDateEnd;
    }

    public void setYearOfDateEnd(String yearOfDateEnd) {
        this.yearOfDateEnd = yearOfDateEnd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
