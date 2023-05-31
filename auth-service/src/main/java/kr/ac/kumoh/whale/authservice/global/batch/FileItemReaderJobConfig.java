package kr.ac.kumoh.whale.authservice.global.batch;

import kr.ac.kumoh.whale.authservice.domain.jobs.dto.JobAnnouncementDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader csvReader;

    // 발전소 정보
    private final JobAnnouncementCsvWriter jobAnnouncementCsvWriter;
    
    private static final int chunkSize = 1000;

    @Bean
    public Job jobAnnouncementCsvFileItemReaderJob() {
        return jobBuilderFactory.get("jobAnnouncementCsvFileItemReaderJob")
                .start(jobAnnouncementCsvFileItemReaderStep())
                .build();
    }

    @Bean
    public Step jobAnnouncementCsvFileItemReaderStep() {
        return stepBuilderFactory.get("jobAnnouncementCsvFileItemReaderStep")
                .<JobAnnouncementDto, JobAnnouncementDto>chunk(chunkSize)
                .reader(csvReader.csvFileItemReader())
                .writer(jobAnnouncementCsvWriter)
                .build();
    }
}
