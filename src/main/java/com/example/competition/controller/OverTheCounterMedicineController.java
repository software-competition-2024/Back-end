package com.example.competition.controller;

import com.example.competition.dto.OverTheCounterMedicineDto;
import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.service.OverTheCounterMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/otc-medicines")
public class OverTheCounterMedicineController {

    @Autowired
    private OverTheCounterMedicineService overTheCounterMedicineService;

    @PostMapping
    public ResponseEntity<OverTheCounterMedicineDto> createOverTheCounterMedicine(@RequestBody OverTheCounterMedicineDto dto) {
        OverTheCounterMedicine savedMedicine = overTheCounterMedicineService.saveOverTheCounterMedicine(dto);
        OverTheCounterMedicineDto savedDto = new OverTheCounterMedicineDto(
                savedMedicine.getId(),
                savedMedicine.getProductName(),
                "D-" + ChronoUnit.DAYS.between(LocalDate.now(), savedMedicine.getExpirationDate()),
                savedMedicine.getExpirationDate(),
                savedMedicine.getOpeningDate(),
                savedMedicine.getDosage(),
                savedMedicine.getIngredients(),
                savedMedicine.getClassification(), // 필드 추가
                ChronoUnit.DAYS.between(LocalDate.now(), savedMedicine.getExpirationDate()),
                savedMedicine.getUser().getEmail(),
                savedMedicine.getPushNotificationSent() // 필드 추가
        );
        return ResponseEntity.ok(savedDto);
    }
}
