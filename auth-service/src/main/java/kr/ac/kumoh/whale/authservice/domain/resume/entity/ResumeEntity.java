package kr.ac.kumoh.whale.authservice.domain.resume.entity;

import kr.ac.kumoh.whale.authservice.domain.member.entity.MemberEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "resumes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", unique = true, nullable = false)
    private MemberEntity member;

    // 전공
    private String major;
    // 최종 학력
    @Enumerated(value = EnumType.STRING)
    private Education education;
    // 선호 연봉
    private long preferIncome;
    // 선호 근무 형태
    @Enumerated(value = EnumType.STRING)
    private WorkType workType;
    // 경력
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Career> careerList;
    // 자격증
    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Certification> certifications;
    // 선호 키워드
    private String preferKeyword;

    @Builder
    public ResumeEntity(MemberEntity member, String major, Education education, long preferIncome, WorkType workType, List<Career> careerList, List<Certification> certifications, String preferKeyword) {
        this.member = member;
        this.major = major;
        this.education = education;
        this.preferIncome = preferIncome;
        this.workType = workType;
        this.careerList = careerList;
        this.certifications = certifications;
        this.preferKeyword = preferKeyword;
    }

    public void addCareer(Career career){
        career.setResume(this);
        this.careerList.add(career);
    }

    public void setMember(MemberEntity member){
        this.member = member;
    }

    public void setCareerList(List<Career> careers) {
        for(Career career:careers){
            this.addCareer(career);
        }
    }
}
