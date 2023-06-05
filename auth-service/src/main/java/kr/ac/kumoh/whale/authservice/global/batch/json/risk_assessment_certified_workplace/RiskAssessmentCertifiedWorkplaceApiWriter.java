package kr.ac.kumoh.whale.authservice.global.batch.json.risk_assessment_certified_workplace;

import kr.ac.kumoh.whale.authservice.global.batch.json.health_center.HealthCenterInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RiskAssessmentCertifiedWorkplaceApiWriter implements ItemWriter<RiskAssessmentCertifiedWorkplace> {
    private final RiskAssessmentCertifiedWorkplaceRepository riskAssessmentCertifiedWorkplaceRepository;

    @Override
    public void write(List<? extends RiskAssessmentCertifiedWorkplace> list) throws Exception {
        List<RiskAssessmentCertifiedWorkplace> riskAssessmentCertifiedWorkplaces = new ArrayList<>();

        // dto -> entity
        list.forEach(healthCenterInfo->{
            riskAssessmentCertifiedWorkplaces.add(healthCenterInfo);
        });

        riskAssessmentCertifiedWorkplaceRepository.saveAll(riskAssessmentCertifiedWorkplaces);
    }
}