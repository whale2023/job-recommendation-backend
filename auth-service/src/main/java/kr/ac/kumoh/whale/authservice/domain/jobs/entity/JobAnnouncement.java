package kr.ac.kumoh.whale.authservice.domain.jobs.entity;

import kr.ac.kumoh.whale.authservice.domain.jobs.dto.JobAnnouncementDto;
import kr.ac.kumoh.whale.authservice.domain.member.entity.MemberEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "job_announcement")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobAnnouncement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_announcement_id")
    // 연번
    private Long id;
    // 구인 신청일자
    private String applicationDate;
    // 모집 기간
    private String recruitmentPeriod;
    // 사업장명
    private String companyName;
    // 모집직종
    private String recruitmentType;
    // 고용형태
    private String typeOfEmployment;
    // 임금형태
    private String formOfWages;
    // 임금
    private String wage;
    // 입사형태
    private String entryForm;
    // 요구경력
    private String requiredExperience;
    // 요구학력
    private String requiredEducation;
    // 전공 계열
    private String majorField;
    // 요구자격증
    private String requiredCredentials;
    // 사업장 주소
    private String businessAddress;
    // 기업 형태
    private String companyType;
    // 담당기관
    private String responsibleAgency;
    // 등록일
    private String registrationDate;
    // 연락처
    private String contactNumber;


    @ManyToMany(mappedBy = "wishlist")
    private Set<MemberEntity> members = new HashSet<>();

    private JobAnnouncement(String applicationDate, String recruitmentPeriod, String companyName, String recruitmentType, String typeOfEmployment, String formOfWages, String wage, String entryForm, String requiredExperience, String requiredEducation, String majorField, String requiredCredentials, String businessAddress, String companyType, String responsibleAgency, String registrationDate, String contactNumber) {
        this.applicationDate = applicationDate;
        this.recruitmentPeriod = recruitmentPeriod;
        this.companyName = companyName;
        this.recruitmentType = recruitmentType;
        this.typeOfEmployment = typeOfEmployment;
        this.formOfWages = formOfWages;
        this.wage = wage;
        this.entryForm = entryForm;
        this.requiredExperience = requiredExperience;
        this.requiredEducation = requiredEducation;
        this.majorField = majorField;
        this.requiredCredentials = requiredCredentials;
        this.businessAddress = businessAddress;
        this.companyType = companyType;
        this.responsibleAgency = responsibleAgency;
        this.registrationDate = registrationDate;
        this.contactNumber = contactNumber;
    }

    public static JobAnnouncement createJobAnnouncement(JobAnnouncementDto dto){
        return new JobAnnouncement(dto.getApplicationDate(),dto.getRecruitmentPeriod(),dto.getCompanyName(),dto.getRecruitmentType(),dto.getTypeOfEmployment(),dto.getFormOfWages(),dto.getWage(),dto.getEntryForm(),dto.getRequiredExperience(),dto.getRequiredEducation(),dto.getMajorField(),dto.getRequiredCredentials(),dto.getBusinessAddress(),dto.getCompanyType(),dto.getResponsibleAgency(),dto.getRegistrationDate(),dto.getContactNumber());
    }
}
