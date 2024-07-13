package com.example.competition.service;

import com.example.competition.dto.PrescriptionMedicineDto;
import com.example.competition.model.PrescriptionMedicine;
import com.example.competition.repository.PrescriptionMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.time.temporal.ChronoUnit;

@Service
public class PrescriptionMedicineService {

    @Autowired
    private PrescriptionMedicineRepository prescriptionMedicineRepository;

    public PrescriptionMedicineDto getPrescriptionMedicineById(Long id) {
        Optional<PrescriptionMedicine> prescriptionOpt = prescriptionMedicineRepository.findById(id);
        if (prescriptionOpt.isPresent()) {
            PrescriptionMedicine prescription = prescriptionOpt.get();
            LocalDate expirationDate = prescription.getExpirationDate();
            LocalDate prescriptionDate = prescription.getPrescriptionDate();
            long diff = ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
            return new PrescriptionMedicineDto(
                    id,
                    prescription.getMedicineName(),
                    "D-" + diff,
                    expirationDate,
                    prescriptionDate,
                    prescription.getDosageInstruction(),
                    prescription.getPrecautions(),
                    diff
            );
        }
        return null;
    }
    public void deletePrescriptionMedicine(Long id) {
        prescriptionMedicineRepository.deleteById(id);
    }
}
