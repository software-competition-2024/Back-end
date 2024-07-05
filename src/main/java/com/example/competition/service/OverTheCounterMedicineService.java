package com.example.competition.service;

import com.example.competition.model.OverTheCounterMedicine;

import java.util.List;

public interface OverTheCounterMedicineService {

    OverTheCounterMedicine registerMedicine(OverTheCounterMedicine medicine);

    List<OverTheCounterMedicine> getAllMedicines();

    void deleteMedicine(Long id);

}
