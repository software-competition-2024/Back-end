package com.example.competition.repository;

import com.example.competition.model.OverTheCounterMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverTheCounterMedicineRepository extends JpaRepository<OverTheCounterMedicine, Long> {
}
