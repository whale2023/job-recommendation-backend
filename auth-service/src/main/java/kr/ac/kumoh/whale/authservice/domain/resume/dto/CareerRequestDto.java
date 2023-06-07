package kr.ac.kumoh.whale.authservice.domain.resume.dto;

import kr.ac.kumoh.whale.authservice.domain.resume.entity.Career;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.JobCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerRequestDto {

    private int period;
    private String category;

    public CareerRequestDto(Career career) {
        this.period = career.getPeriod();
        this.category = career.getCategory().getDisplayName();
    }
}
