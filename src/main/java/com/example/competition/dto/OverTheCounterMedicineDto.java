package com.example.competition.dto;

import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OverTheCounterMedicineDto {
    private Long id;
    private String productName;
    private String expirationDays;
    private LocalDate expirationDate;
    private LocalDate openingDate;
    private String dosage;
    private String ingredients;
    private String classification;  // 필드 추가
    private long expirationDaysInNumber;
    private String userEmail;
    private Boolean pushNotificationSent;  // 필드 추가

    // 생성자, getter, setter

    public OverTheCounterMedicineDto(Long id, String productName, String expirationDays, LocalDate expirationDate, LocalDate openingDate, String dosage, String ingredients, String classification, long expirationDaysInNumber, String userEmail, Boolean pushNotificationSent) {
        this.id = id;
        this.productName = productName;
        this.expirationDays = expirationDays;
        this.expirationDate = expirationDate;
        this.openingDate = openingDate;
        this.dosage = dosage;
        this.ingredients = ingredients;
        this.classification = classification;
        this.expirationDaysInNumber = expirationDaysInNumber;
        this.userEmail = userEmail;
        this.pushNotificationSent = pushNotificationSent;
    }

    public OverTheCounterMedicine toModel(User user) {
        OverTheCounterMedicine medicine = new OverTheCounterMedicine();
        medicine.setId(this.id);
        medicine.setProductName(this.productName);
        medicine.setExpirationDate(this.expirationDate);
        medicine.setOpeningDate(this.openingDate);
        medicine.setDosage(this.dosage);
        medicine.setIngredients(this.ingredients);
        medicine.setClassification(this.classification);  // 필드 설정
        medicine.setUser(user);
        medicine.setPushNotificationSent(this.pushNotificationSent);  // 필드 설정
        return medicine;
    }
}