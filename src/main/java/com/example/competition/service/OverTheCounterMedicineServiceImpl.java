package com.example.competition.service;

import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.repository.OverTheCounterMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverTheCounterMedicineServiceImpl implements OverTheCounterMedicineService {

    private final OverTheCounterMedicineRepository otcMedicineRepository;

    @Autowired
    public OverTheCounterMedicineServiceImpl(OverTheCounterMedicineRepository otcMedicineRepository) {
        this.otcMedicineRepository = otcMedicineRepository;
    }

    @Override
    public OverTheCounterMedicine registerMedicine(OverTheCounterMedicine medicine) {
        return otcMedicineRepository.save(medicine);
    }

    @Override
    public List<OverTheCounterMedicine> getAllMedicines() {
        return otcMedicineRepository.findAll();
    }

    @Override
    public void deleteMedicine(Long id) {
        otcMedicineRepository.deleteById(id);
    }
}
