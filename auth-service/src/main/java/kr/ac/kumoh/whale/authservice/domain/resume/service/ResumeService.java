package kr.ac.kumoh.whale.authservice.domain.resume.service;


import kr.ac.kumoh.whale.authservice.domain.member.entity.MemberEntity;
import kr.ac.kumoh.whale.authservice.domain.member.repository.MemberRepository;
import kr.ac.kumoh.whale.authservice.domain.resume.dto.CareerDto;
import kr.ac.kumoh.whale.authservice.domain.resume.dto.ResumeDto;
import kr.ac.kumoh.whale.authservice.domain.resume.dto.ResumeRequest;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.Career;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.ResumeEntity;
import kr.ac.kumoh.whale.authservice.domain.resume.repository.ResumeRepository;
import kr.ac.kumoh.whale.authservice.global.error.exception.EntityNotFoundException;
import kr.ac.kumoh.whale.authservice.global.error.exception.InvalidValueException;
import kr.ac.kumoh.whale.authservice.global.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeRepository resumeRepository;
    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;

    @Transactional
    public ResumeDto createResume(String token, ResumeRequest resumeRequest){
        String userEmail = tokenProvider.validateJwtAndGetUserEmail(token);
        MemberEntity member = memberRepository.findByEmail(userEmail)
                .orElseThrow(()->new EntityNotFoundException("사용자를 찾을 수 없습니다."));
        if (resumeRepository.existsByMember_Email(userEmail)){
            throw new InvalidValueException("이미 이력서가 존재합니다");
        }

        ResumeEntity resume = ResumeEntity.builder()
                .member(member)
                .preferIncome(resumeRequest.getPreferIncome())
                .workType(resumeRequest.getWorkType())
                .education(resumeRequest.getEducation())
                .major(resumeRequest.getMajor())
                .careerList(new ArrayList<>())
                .certifications(resumeRequest.getCertifications())
                .build();

        // 경력 생성 및 추가
        List<Career> careers = new ArrayList<>();
        for (CareerDto careerRequest : resumeRequest.getCareers()) {
            Career career = Career.builder()
                    .period(careerRequest.getPeriod())
                    .category(careerRequest.getCategory())
                    .build();
            career.setResume(resume);
            careers.add(career);
        }
        resume.setCareerList(careers);

        ResumeEntity savedResume = resumeRepository.save(resume);

        member.writeResume(resume);
        memberRepository.save(member);

        ResumeDto response = Optional.ofNullable(savedResume).map(ResumeDto::new)
            .orElseThrow(()->new InvalidValueException("dto 변환 실패"));

        return response;
    }

    public ResumeDto getResume(String accessToken) {
        String userEmail = tokenProvider.validateJwtAndGetUserEmail(accessToken);
        ResumeEntity resumeEntity = resumeRepository.findByMember_Email(userEmail)
                .orElseThrow(()->new EntityNotFoundException("작성한 이력서를 찾을 수 없습니다."));

        ResumeDto response = Optional.ofNullable(resumeEntity).map(ResumeDto::new)
                .orElseThrow(()->new InvalidValueException("dto 변환 실패"));

        return response;
    }
}
