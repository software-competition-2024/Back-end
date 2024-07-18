package com.example.competition.controller;

import com.example.competition.dto.MedicineHomeDto;
import com.example.competition.dto.OverTheCounterMedicineDto;
import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.service.MedicineService;
import com.example.competition.service.OverTheCounterMedicineService;
import com.example.competition.service.PrescriptionMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PrescriptionMedicineService prescriptionMedicineService;

    @Autowired
    private OverTheCounterMedicineService overTheCounterMedicineService;

    @GetMapping
    public ResponseEntity<List<MedicineHomeDto>> getHomeData(
            @RequestParam(required = false, defaultValue = "전체") String type,
            @RequestParam(required = false, defaultValue = "등록순") String sort,
            @RequestParam(required = false, defaultValue = "") String search
    ) {
        List<MedicineHomeDto> homeData = medicineService.getHomeMedicineData(type, sort, search);
        return ResponseEntity.ok(homeData);
    }

    @GetMapping("/{id}/{type}")
    public ResponseEntity<Object> getMedicineByIdAndType(@PathVariable Long id, @PathVariable String type) {
        Object medicine = null;
        if ("prescription".equals(type)) {
            medicine = prescriptionMedicineService.getPrescriptionMedicineById(id);
        } else if ("over_the_counter".equals(type)) {
            medicine = overTheCounterMedicineService.getOverTheCounterMedicineById(id);
        }
        if (medicine != null) {
            return ResponseEntity.ok(medicine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/{type}")
    public ResponseEntity<?> deleteMedicineByIdAndType(@PathVariable Long id, @PathVariable String type) {
        if ("prescription".equals(type)) {
            prescriptionMedicineService.deletePrescriptionMedicine(id);
        } else if ("over_the_counter".equals(type)) {
            overTheCounterMedicineService.deleteOverTheCounterMedicine(id);
        } else {
            return ResponseEntity.badRequest().body("Invalid type");
        }
        return ResponseEntity.ok("Medicine deleted successfully");
    }

}
