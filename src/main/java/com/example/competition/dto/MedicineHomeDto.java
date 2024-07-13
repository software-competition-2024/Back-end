package com.example.competition.dto;

public class MedicineHomeDto {
    private Long id;
    private String medicineName;
    private String medicineType;
    private String expirationDays;
    private long expirationDaysInNumber;
    private String type; // 추가된 필드

    public MedicineHomeDto(Long id, String medicineName, String medicineType, String expirationDays, long expirationDaysInNumber, String type) {
        this.id = id;
        this.medicineName = medicineName;
        this.medicineType = medicineType;
        this.expirationDays = expirationDays;
        this.expirationDaysInNumber = expirationDaysInNumber;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
