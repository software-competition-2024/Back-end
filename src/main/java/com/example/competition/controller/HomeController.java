package com.example.competition.controller;

import com.example.competition.dto.MedicineHomeDto;
import com.example.competition.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public ResponseEntity<List<MedicineHomeDto>> getHomeData(
            @RequestParam(required = false, defaultValue = "전체") String type,
            @RequestParam(required = false, defaultValue = "등록순") String sort,
            @RequestParam(required = false, defaultValue = "") String search
    ) {
        List<MedicineHomeDto> homeData = medicineService.getHomeMedicineData(type, sort, search);
        return ResponseEntity.ok(homeData);
    }
}
