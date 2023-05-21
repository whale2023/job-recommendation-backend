package kr.ac.kumoh.whale.authservice.domain.resume.dto;

import kr.ac.kumoh.whale.authservice.domain.resume.entity.Certification;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.Education;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.WorkType;
import lombok.Data;

import java.util.List;

@Data
public class ResumeRequest {
    private String major;
    private Education education;
    private long preferIncome;
    private WorkType workType;
    private List<Certification> certifications;
    private List<CareerDto> careers;
}


