package com.example.competition.service;

import com.example.competition.dto.MedicineHomeDto;
import com.example.competition.model.PrescriptionMedicine;
import com.example.competition.model.OverTheCounterMedicine;
import com.example.competition.repository.PrescriptionMedicineRepository;
import com.example.competition.repository.OverTheCounterMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

@Service
public class MedicineService {

    @Autowired
    private PrescriptionMedicineRepository prescriptionMedicineRepository;

    @Autowired
    private OverTheCounterMedicineRepository overTheCounterMedicineRepository;

    public List<MedicineHomeDto> getHomeMedicineData(String type, String sort, String search) {
        List<MedicineHomeDto> homeData = new ArrayList<>();
        LocalDate today = LocalDate.now();

        // 처방약 데이터 추가
        List<PrescriptionMedicine> prescriptions = prescriptionMedicineRepository.findAll();
        for (PrescriptionMedicine prescription : prescriptions) {
            LocalDate expirationDate = prescription.getExpirationDate();
            long diff = ChronoUnit.DAYS.between(today, expirationDate);
            homeData.add(new MedicineHomeDto(
                    prescription.getMedicineName(),
                    "처방약",
                    "D-" + diff,
                    diff
            ));
        }

        // 상비약 데이터 추가
        List<OverTheCounterMedicine> overTheCounters = overTheCounterMedicineRepository.findAll();
        for (OverTheCounterMedicine overTheCounter : overTheCounters) {
            LocalDate expirationDate = overTheCounter.getExpirationDate();
            long diff = ChronoUnit.DAYS.between(today, expirationDate);
            homeData.add(new MedicineHomeDto(
                    overTheCounter.getProductName(),
                    "상비약",
                    "D-" + diff,
                    diff
            ));
        }

        // 검색 필터링
        if (!search.isEmpty()) {
            homeData = homeData.stream()
                    .filter(m -> m.getMedicineName().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }

        // 타입 필터링
        if (!type.equals("전체")) {
            homeData = homeData.stream()
                    .filter(m -> m.getMedicineType().equals(type))
                    .collect(Collectors.toList());
        }

        // 정렬
        if (sort.equals("등록순")) {
            homeData.sort(Comparator.comparing(MedicineHomeDto::getMedicineName));
        } else if (sort.equals("유통기한 임박순")) {
            homeData.sort(Comparator.comparingLong(MedicineHomeDto::getExpirationDaysInNumber));
        }

        return homeData;
    }
}
