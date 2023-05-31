package kr.ac.kumoh.whale.authservice.domain.jobs.service;

import kr.ac.kumoh.whale.authservice.domain.jobs.dto.JobAnnouncementDto;
import kr.ac.kumoh.whale.authservice.domain.jobs.entity.JobAnnouncement;
import kr.ac.kumoh.whale.authservice.domain.jobs.repository.JobAnnouncementRepository;
import kr.ac.kumoh.whale.authservice.domain.member.entity.MemberEntity;
import kr.ac.kumoh.whale.authservice.domain.member.repository.MemberRepository;
import kr.ac.kumoh.whale.authservice.global.error.exception.EntityNotFoundException;
import kr.ac.kumoh.whale.authservice.global.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobAnnouncementService {
    private final JobAnnouncementRepository jobAnnouncementRepository;
    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;

    public void addToWishlist(String accessToken, Long jobAnnouncementId) {
        String email = tokenProvider.validateJwtAndGetUserEmail(accessToken);
        MemberEntity member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("사용자를 찾을 수 없습니다"));

        JobAnnouncement jobAnnouncement = jobAnnouncementRepository.findById(jobAnnouncementId)
                .orElseThrow(()-> new EntityNotFoundException("공고를 찾을 수 없습니다"));

        member.addToWishlist(jobAnnouncement);

        memberRepository.save(member);
    }

    public void removeFromWishlist(String accessToken, Long jobAnnouncementId) {
        String email = tokenProvider.validateJwtAndGetUserEmail(accessToken);
        MemberEntity member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("사용자를 찾을 수 없습니다"));

        JobAnnouncement jobAnnouncement = jobAnnouncementRepository.findById(jobAnnouncementId)
                .orElseThrow(()-> new EntityNotFoundException("공고를 찾을 수 없습니다"));

        member.removeFromWishlist(jobAnnouncement);

        memberRepository.save(member);
    }

    public List<JobAnnouncementDto> getAnnouncementPage(Pageable pageable){
        Page<JobAnnouncement> announcementList = jobAnnouncementRepository.findAll(pageable);
        List<JobAnnouncementDto> announcementDtos = announcementList.map(JobAnnouncementDto::new).stream().collect(Collectors.toList());

        return announcementDtos;
    }
}
