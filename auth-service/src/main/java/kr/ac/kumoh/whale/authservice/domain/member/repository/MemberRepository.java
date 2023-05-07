package kr.ac.kumoh.whale.authservice.domain.member.repository;

import kr.ac.kumoh.whale.authservice.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String memberEmail);

    boolean existsByEmail(String memberEmail);
}
