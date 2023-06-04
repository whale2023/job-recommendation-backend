package kr.ac.kumoh.whale.authservice.global.batch.json.barrier_free_certified_workplace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarrierFreeCertifiedWorkplaceRepository extends JpaRepository<BarrierFreeCertifiedWorkplace, Long> {
}
