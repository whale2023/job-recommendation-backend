package kr.ac.kumoh.whale.authservice.domain.resume.dto;

import kr.ac.kumoh.whale.authservice.domain.resume.entity.Career;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.JobCategory;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.ResumeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerDto {

    private int period;
    private JobCategory category;

    public CareerDto(Career career) {
        this.period = career.getPeriod();
        this.category = career.getCategory();
    }
}
