package com.example.competition.dto;

public class MedicineHomeDto {
    private String medicineName;
    private String medicineType; // "처방약" 또는 "상비약"
    private String expirationDays;
    private long expirationDaysInNumber; // 숫자로 유통기한을 저장

    public MedicineHomeDto(String medicineName, String medicineType, String expirationDays, long expirationDaysInNumber) {
        this.medicineName = medicineName;
        this.medicineType = medicineType;
        this.expirationDays = expirationDays;
        this.expirationDaysInNumber = expirationDaysInNumber;
    }

    // Getters and Setters
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(String expirationDays) {
        this.expirationDays = expirationDays;
    }

    public long getExpirationDaysInNumber() {
        return expirationDaysInNumber;
    }

    public void setExpirationDaysInNumber(long expirationDaysInNumber) {
        this.expirationDaysInNumber = expirationDaysInNumber;
    }
}
