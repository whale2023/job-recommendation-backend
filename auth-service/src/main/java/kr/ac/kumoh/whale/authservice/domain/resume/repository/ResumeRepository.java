package kr.ac.kumoh.whale.authservice.domain.resume.repository;

import kr.ac.kumoh.whale.authservice.domain.resume.entity.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<ResumeEntity, Long> {
    Optional<ResumeEntity> findByMember_Email(String userEmail);
    boolean existsByMember_Email(String userEmail);
}
