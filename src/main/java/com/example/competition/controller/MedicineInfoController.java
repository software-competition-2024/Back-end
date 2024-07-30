package com.example.competition.controller;

import com.example.competition.model.MedicineInfo;
import com.example.competition.service.MedicineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine-info")
public class MedicineInfoController {

    @Autowired
    private MedicineInfoService medicineInfoService;

    @GetMapping("/{productName}")
    public ResponseEntity<List<MedicineInfo>> getMedicineInfo(@PathVariable String productName) {
        List<MedicineInfo> medicineInfoList = medicineInfoService.getMedicineInfoByProductName(productName);
        if (!medicineInfoList.isEmpty()) {
            return ResponseEntity.ok(medicineInfoList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
