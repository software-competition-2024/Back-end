package com.example.competition.service;

import com.example.competition.dto.OverTheCounterMedicineDto;
import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.model.User;
import com.example.competition.repository.OverTheCounterMedicineRepository;
import com.example.competition.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class OverTheCounterMedicineService {

    @Autowired
    private OverTheCounterMedicineRepository overTheCounterMedicineRepository;

    @Autowired
    private UserRepository userRepository;

    public OverTheCounterMedicineDto getOverTheCounterMedicineById(Long id) {
        Optional<OverTheCounterMedicine> overTheCounterOpt = overTheCounterMedicineRepository.findById(id);
        if (overTheCounterOpt.isPresent()) {
            OverTheCounterMedicine overTheCounter = overTheCounterOpt.get();
            LocalDate expirationDate = overTheCounter.getExpirationDate();
            LocalDate openingDate = overTheCounter.getOpeningDate();
            long diff = ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
            return new OverTheCounterMedicineDto(
                    id,
                    overTheCounter.getProductName(),
                    "D-" + diff,
                    expirationDate,
                    openingDate,
                    overTheCounter.getDosage(),
                    overTheCounter.getIngredients(),
                    overTheCounter.getClassification(), // 필드 추가
                    diff,
                    overTheCounter.getUser().getEmail(),
                    overTheCounter.getPushNotificationSent() // 필드 추가
            );
        }
        return null;
    }

    public void deleteOverTheCounterMedicine(Long id) {
        overTheCounterMedicineRepository.deleteById(id);
    }

    public OverTheCounterMedicine saveOverTheCounterMedicine(OverTheCounterMedicineDto dto) {
        User user = userRepository.findByEmail(dto.getUserEmail());
        OverTheCounterMedicine medicine = dto.toModel(user);
        return overTheCounterMedicineRepository.save(medicine);
    }
}
