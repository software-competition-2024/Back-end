package com.example.competition.controller;

import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.service.OverTheCounterMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/otc/medicines")
public class OverTheCounterMedicineController {

    private final OverTheCounterMedicineService medicineService;

    @Autowired
    public OverTheCounterMedicineController(OverTheCounterMedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping
    public ResponseEntity<OverTheCounterMedicine> registerMedicine(@RequestBody OverTheCounterMedicine medicine) {
        OverTheCounterMedicine savedMedicine = medicineService.registerMedicine(medicine);
        return new ResponseEntity<>(savedMedicine, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OverTheCounterMedicine>> getAllMedicines() {
        List<OverTheCounterMedicine> medicines = medicineService.getAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }
}
