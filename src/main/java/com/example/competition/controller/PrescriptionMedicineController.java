package com.example.competition.controller;

import com.example.competition.dto.PrescriptionMedicineDto;
import com.example.competition.model.PrescriptionMedicine;
import com.example.competition.service.PrescriptionMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/pst-medicines")
public class PrescriptionMedicineController {

    @Autowired
    private PrescriptionMedicineService PrescriptionMedicineService;

    @PostMapping
    public ResponseEntity<PrescriptionMedicineDto> createPrescriptionMedicine(@RequestBody PrescriptionMedicineDto dto) {
        PrescriptionMedicine savedMedicine = PrescriptionMedicineService.savePrescriptionMedicine(dto);
        PrescriptionMedicineDto savedDto = new PrescriptionMedicineDto(
                savedMedicine.getId(),
                savedMedicine.getMedicineName(),
                "D-" + ChronoUnit.DAYS.between(LocalDate.now(), savedMedicine.getExpirationDate()),
                savedMedicine.getExpirationDate(),
                savedMedicine.getPrescriptionDate(),
                savedMedicine.getDosageInstruction(),
                savedMedicine.getPrecautions(),
                ChronoUnit.DAYS.between(LocalDate.now(), savedMedicine.getExpirationDate()),
                savedMedicine.getUser().getEmail(),
                savedMedicine.getPushNotification(),
                savedMedicine.getDosageNotification()
        );
        return ResponseEntity.ok(savedDto);
    }
}
