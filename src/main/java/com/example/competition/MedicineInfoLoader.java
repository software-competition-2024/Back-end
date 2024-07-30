package com.example.competition;

import com.example.competition.model.MedicineInfo;
import com.example.competition.repository.MedicineInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MedicineInfoLoader implements CommandLineRunner {

    @Autowired
    private MedicineInfoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // 데이터 삽입
        MedicineInfo medicine1 = new MedicineInfo();
        medicine1.setProductName("타이레놀정 500mg");
        medicine1.setIngredients("아세트아미노펜 500mg");
        medicine1.setClassification("해열, 진통, 소염제");
        medicine1.setDosage("만 12세 이상 소아 및 성인: 1회 1~2정씩 1일 3-4회 (4-6시간 마다) 필요시 복용한다. 1일 최대 4그램 (8정)을 초과하여 복용하지 않는다.");

        MedicineInfo medicine2 = new MedicineInfo();
        medicine2.setProductName("후시딘연고");
        medicine2.setIngredients("퓨시드산나트륨 20mg/g");
        medicine2.setClassification("항생제");
        medicine2.setDosage("환부를 깨끗이 하고 1일 1~2회 적당량을 환부에 직접 바르거나 무균거즈에 넓게 펴발라 붙인다.");

        repository.save(medicine1);
        repository.save(medicine2);
    }
}
