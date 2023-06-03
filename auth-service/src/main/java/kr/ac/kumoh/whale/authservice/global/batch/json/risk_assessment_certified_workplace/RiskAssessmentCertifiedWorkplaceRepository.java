package kr.ac.kumoh.whale.authservice.global.batch.json.risk_assessment_certified_workplace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskAssessmentCertifiedWorkplaceRepository extends JpaRepository<RiskAssessmentCertifiedWorkplace, Long> {
}
