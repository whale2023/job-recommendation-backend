package kr.ac.kumoh.whale.authservice.domain.resume.repository;

import kr.ac.kumoh.whale.authservice.domain.resume.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
