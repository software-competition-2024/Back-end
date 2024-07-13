package com.example.competition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "prescription_medicine")
public class PrescriptionMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate prescriptionDate;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private String medicineName;

    private String dosageInstruction;
    private String precautions;

    @Column(nullable = false)
    private Boolean pushNotification = true;

    @Column(nullable = false)
    private Boolean dosageNotification = false;

    @ManyToOne
    @JoinColumn(name = "user_email",referencedColumnName = "email", nullable = false)
    private User user;

   /* // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
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

    public Boolean getPushNotification() {
        return pushNotification;
    }

    public void setPushNotification(Boolean pushNotification) {
        this.pushNotification = pushNotification;
    }

    public Boolean getDosageNotification() {
        return dosageNotification;
    }

    public void setDosageNotification(Boolean dosageNotification) {
        this.dosageNotification = dosageNotification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
