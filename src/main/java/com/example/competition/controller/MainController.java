package com.example.competition.controller;

import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.service.OverTheCounterMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/otc-medicines")
public class MainController {

    private final OverTheCounterMedicineService otcMedicineService;

    @Autowired
    public MainController(OverTheCounterMedicineService otcMedicineService) {
        this.otcMedicineService = otcMedicineService;
    }

    @PostMapping("/otc/register")
    public ResponseEntity<OverTheCounterMedicine> registerOverTheCounterMedicine(
            @RequestBody OverTheCounterMedicine medicine) {
        OverTheCounterMedicine registeredMedicine = otcMedicineService.registerMedicine(medicine);
        return new ResponseEntity<>(registeredMedicine, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OverTheCounterMedicine>> getAllOverTheCounterMedicines() {
        List<OverTheCounterMedicine> medicines = otcMedicineService.getAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOverTheCounterMedicine(@PathVariable Long id) {
        otcMedicineService.deleteMedicine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
