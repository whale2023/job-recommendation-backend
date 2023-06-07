package kr.ac.kumoh.whale.authservice.domain.resume.dto;

import kr.ac.kumoh.whale.authservice.domain.resume.entity.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResumeDto {
    // 전공
    private String major;
    // 최종 학력
    private Education education;
    // 선호 연봉
    private long preferIncome;
    // 선호 근무 형태
    private WorkType workType;
    // 경력
    private List<CareerDto> careerList;
    // 자격증
    private List<Certification> certifications;
    // 선호 키워드
    private String preferKeyword;

    public ResumeDto(ResumeEntity entity) {
        this.major = entity.getMajor();
        this.education = entity.getEducation();
        this.preferIncome = entity.getPreferIncome();
        this.workType = entity.getWorkType();
        this.careerList = entity.getCareerList().stream().map(CareerDto::new).collect(Collectors.toList());
        this.certifications = entity.getCertifications();
        this.preferKeyword = entity.getPreferKeyword();
    }
}
