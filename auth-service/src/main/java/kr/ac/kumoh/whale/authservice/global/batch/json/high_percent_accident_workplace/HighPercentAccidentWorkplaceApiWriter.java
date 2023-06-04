package kr.ac.kumoh.whale.authservice.global.batch.json.high_percent_accident_workplace;

import kr.ac.kumoh.whale.authservice.global.batch.json.accident_workplace.AccidentWorkplace;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class HighPercentAccidentWorkplaceApiWriter implements ItemWriter<HighPercentAccidentWorkplace> {
    private final HighPercentAccidentWorkplaceRepository highPercentAccidentWorkplaceRepository;
    @Override
    public void write(List<? extends HighPercentAccidentWorkplace> list) throws Exception {
        List<HighPercentAccidentWorkplace> highPercentAccidentWorkplaces = new ArrayList<>();

        // dto -> entity
        list.forEach(highPercentAccidentWorkplace->{
            highPercentAccidentWorkplaces.add(highPercentAccidentWorkplace);
        });

        highPercentAccidentWorkplaceRepository.saveAll(highPercentAccidentWorkplaces);
    }
}
