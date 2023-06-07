package kr.ac.kumoh.whale.authservice.domain.jobs.repository;

import kr.ac.kumoh.whale.authservice.domain.jobs.entity.JobAnnouncement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAnnouncementRepository extends JpaRepository<JobAnnouncement, Long> {
    Page<JobAnnouncement> findAll(Pageable pageable);
    @Query("SELECT ja FROM JobAnnouncement ja ORDER BY SIZE(ja.members) DESC")
    Page<JobAnnouncement> findAllOrderByMembersCount(Pageable pageable);
}
