package com.example.competition.dto;

import java.time.LocalDate;

public class PrescriptionMedicineDto {
    private Long id;
    private String medicineName;
    private String expirationDays;
    private LocalDate expirationDate;
    private LocalDate prescriptionDate;
    private String dosageInstruction;
    private String precautions;
    private long expirationDaysInNumber;

    public PrescriptionMedicineDto(Long id, String medicineName, String expirationDays, LocalDate expirationDate, LocalDate prescriptionDate, String dosageInstruction, String precautions, long expirationDaysInNumber) {
        this.id = id;
        this.medicineName = medicineName;
        this.expirationDays = expirationDays;
        this.expirationDate = expirationDate;
        this.prescriptionDate = prescriptionDate;
        this.dosageInstruction = dosageInstruction;
        this.precautions = precautions;
        this.expirationDaysInNumber = expirationDaysInNumber;
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

    public String getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(String expirationDays) {
        this.expirationDays = expirationDays;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getDosageInstruction() {
        return dosageInstruction;
    }

    public void setDosageInstruction(String dosageInstruction) {
        this.dosageInstruction = dosageInstruction;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public long getExpirationDaysInNumber() {
        return expirationDaysInNumber;
    }

    public void setExpirationDaysInNumber(long expirationDaysInNumber) {
        this.expirationDaysInNumber = expirationDaysInNumber;
    }
}
