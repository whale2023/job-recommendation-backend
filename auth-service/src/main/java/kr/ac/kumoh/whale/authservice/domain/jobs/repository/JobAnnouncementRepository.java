package kr.ac.kumoh.whale.authservice.domain.jobs.repository;

import kr.ac.kumoh.whale.authservice.domain.jobs.entity.JobAnnouncement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAnnouncementRepository extends JpaRepository<JobAnnouncement, Long> {
    Page<JobAnnouncement> findAll(Pageable pageable);
}
