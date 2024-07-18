package com.example.competition.service;

import com.example.competition.model.MedicineInfo;
import com.example.competition.repository.MedicineInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineInfoService {

    @Autowired
    private MedicineInfoRepository repository;

    public List<MedicineInfo> getMedicineInfoByProductName(String productName) {
        return repository.findByProductNameContaining(productName);
    }
}
