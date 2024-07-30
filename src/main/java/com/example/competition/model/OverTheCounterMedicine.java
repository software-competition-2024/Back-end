package com.example.competition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "over_the_counter_medicine")
public class OverTheCounterMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate openingDate;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private String productName;

    private String ingredients;
    private String classification;
    private String dosage;

    @Column(nullable = false)
    private Boolean pushNotificationSent = true;

    @ManyToOne
    @JoinColumn(name = "user_email",referencedColumnName = "email", nullable = false)
    private User user;

    /*// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Boolean getPushNotificationSent() {
        return pushNotificationSent;
    }

    public void setPushNotificationSent(Boolean pushNotificationSent) {
        this.pushNotificationSent = pushNotificationSent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
