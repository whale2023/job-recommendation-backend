package kr.ac.kumoh.whale.authservice.global.batch.json.employment_information;

import kr.ac.kumoh.whale.authservice.global.batch.json.accident_workplace.AccidentWorkplace;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class EmploymentInformationApiWriter implements ItemWriter<EmploymentInformation> {
    private final EmploymentInformationRepository employmentInformationRepository;
    @Override
    public void write(List<? extends EmploymentInformation> list) throws Exception {
        List<EmploymentInformation> employmentInformations = new ArrayList<>();

        // dto -> entity
        list.forEach(employmentInformation->{
            employmentInformations.add(employmentInformation);
        });

        employmentInformationRepository.saveAll(employmentInformations);
    }
}
