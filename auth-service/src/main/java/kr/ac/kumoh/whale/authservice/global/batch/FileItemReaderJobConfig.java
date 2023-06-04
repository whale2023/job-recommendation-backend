package kr.ac.kumoh.whale.authservice.global.batch;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.kumoh.whale.authservice.domain.jobs.dto.JobAnnouncementDto;
import kr.ac.kumoh.whale.authservice.global.batch.json.accident_workplace.AccidentWorkplace;
import kr.ac.kumoh.whale.authservice.global.batch.json.accident_workplace.AccidentWorkplaceApiWriter;
import kr.ac.kumoh.whale.authservice.global.batch.json.barrier_free_certified_workplace.BarrierFreeCertifiedWorkplace;
import kr.ac.kumoh.whale.authservice.global.batch.json.barrier_free_certified_workplace.BarrierFreeCertifiedWorkplaceApiWriter;
import kr.ac.kumoh.whale.authservice.global.batch.json.employment_information.EmploymentInformation;
import kr.ac.kumoh.whale.authservice.global.batch.json.employment_information.EmploymentInformationApiWriter;
import kr.ac.kumoh.whale.authservice.global.batch.json.health_center.HealthCenterApiWriter;
import kr.ac.kumoh.whale.authservice.global.batch.json.health_center.HealthCenterInfo;
import kr.ac.kumoh.whale.authservice.global.batch.json.high_percent_accident_workplace.HighPercentAccidentWorkplace;
import kr.ac.kumoh.whale.authservice.global.batch.json.high_percent_accident_workplace.HighPercentAccidentWorkplaceApiWriter;
import kr.ac.kumoh.whale.authservice.global.batch.json.risk_assessment_certified_workplace.RiskAssessmentCertifiedWorkplace;
import kr.ac.kumoh.whale.authservice.global.batch.json.risk_assessment_certified_workplace.RiskAssessmentCertifiedWorkplaceApiWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader csvReader;
    private final ApiReader apiReader;

    // 발전소 정보
    private final JobAnnouncementCsvWriter jobAnnouncementCsvWriter;
    
    private static final int chunkSize = 1000;
    // 건강센터 정보
    private final HealthCenterApiWriter healthCenterApiWriter;
    // 위험성평가 인정사업장 정보
    private final RiskAssessmentCertifiedWorkplaceApiWriter riskAssessmentCertifiedWorkplaceApiWriter;

    // 배리어프리 인증사업장 정보
    private final BarrierFreeCertifiedWorkplaceApiWriter barrierFreeCertifiedWorkplaceApiWriter;

    // 산업재해 중대산업사고 발생 사업장
    private final AccidentWorkplaceApiWriter accidentWorkplaceApiWriter;

    // 중대재해 발생이 규모별 동종업종 평균재해율 이상인 사업장
    private final HighPercentAccidentWorkplaceApiWriter highPercentAccidentWorkplaceApiWriter;

    // 장애인 고용정보
    private final EmploymentInformationApiWriter employmentInformationApiWriter;

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

    @Bean
    public Job healthCenterApiReaderJob() throws JsonProcessingException, URISyntaxException {
        return jobBuilderFactory.get("healthCenterApiReaderJob")
                .start(healthCenterApiReaderStep())
                .build();
    }

    @Bean
    public Step healthCenterApiReaderStep() throws JsonProcessingException, URISyntaxException {
        return stepBuilderFactory.get("healthCenterApiReaderStep")
                .<HealthCenterInfo, HealthCenterInfo>chunk(chunkSize)
                .reader(apiReader.apiItemReader())
                .writer(healthCenterApiWriter)
                .build();
    }

    @Bean
    public Job riskAssessmentCertifiedWorkplaceApiReaderJob() throws JsonProcessingException, URISyntaxException {
        return jobBuilderFactory.get("riskAssessmentCertifiedWorkplaceApiReaderJob")
                .start(riskAssessmentCertifiedWorkplaceApiReaderStep())
                .build();
    }

    @Bean
    public Step riskAssessmentCertifiedWorkplaceApiReaderStep() throws JsonProcessingException, URISyntaxException {
        return stepBuilderFactory.get("riskAssessmentCertifiedWorkplaceApiReaderStep")
                .<RiskAssessmentCertifiedWorkplace, RiskAssessmentCertifiedWorkplace>chunk(chunkSize)
                .reader(apiReader.riskAssessmentCertifiedWorkplaceItemReader())
                .writer(riskAssessmentCertifiedWorkplaceApiWriter)
                .build();
    }

    @Bean
    public Job barrierFreeCertifiedWorkplaceApiReaderJob() throws JsonProcessingException, URISyntaxException {
        return jobBuilderFactory.get("barrierFreeCertifiedWorkplaceApiReaderJob")
                .start(barrierFreeCertifiedWorkplaceApiReaderStep())
                .build();
    }

    @Bean
    public Step barrierFreeCertifiedWorkplaceApiReaderStep() throws JsonProcessingException, URISyntaxException {
        return stepBuilderFactory.get("barrierFreeCertifiedWorkplaceApiReaderStep")
                .<BarrierFreeCertifiedWorkplace, BarrierFreeCertifiedWorkplace>chunk(chunkSize)
                .reader(apiReader.barrierFreeCertifiedWorkplaceItemReader())
                .writer(barrierFreeCertifiedWorkplaceApiWriter)
                .build();
    }

    @Bean
    public Job accidentWorkplaceApiReaderJob() throws JsonProcessingException, URISyntaxException {
        return jobBuilderFactory.get("accidentWorkplaceApiReaderJob")
                .start(accidentWorkplaceApiReaderStep())
                .build();
    }

    @Bean
    public Step accidentWorkplaceApiReaderStep() throws JsonProcessingException, URISyntaxException {
        return stepBuilderFactory.get("accidentWorkplaceApiReaderStep")
                .<AccidentWorkplace, AccidentWorkplace>chunk(chunkSize)
                .reader(apiReader.accidentWorkplaceItemReader())
                .writer(accidentWorkplaceApiWriter)
                .build();
    }

    @Bean
    public Job highPercentAccidentWorkplaceApiReaderJob() throws JsonProcessingException, URISyntaxException {
        return jobBuilderFactory.get("highPercentAccidentWorkplaceApiReaderJob")
                .start(highPercentAccidentWorkplaceApiReaderStep())
                .build();
    }

    @Bean
    public Step highPercentAccidentWorkplaceApiReaderStep() throws JsonProcessingException, URISyntaxException {
        return stepBuilderFactory.get("highPercentAccidentWorkplaceApiReaderStep")
                .<HighPercentAccidentWorkplace, HighPercentAccidentWorkplace>chunk(chunkSize)
                .reader(apiReader.highPercentAccidentWorkplaceItemReader())
                .writer(highPercentAccidentWorkplaceApiWriter)
                .build();
    }

    @Bean
    public Job employmentInformationApiReaderJob() throws JsonProcessingException, URISyntaxException {
        return jobBuilderFactory.get("employmentInformationApiReaderJob")
                .start(employmentInformationApiReaderStep())
                .build();
    }

    @Bean
    public Step employmentInformationApiReaderStep() throws JsonProcessingException, URISyntaxException {
        return stepBuilderFactory.get("employmentInformationApiReaderStep")
                .<EmploymentInformation, EmploymentInformation>chunk(chunkSize)
                .reader(apiReader.employmentInformationItemReader())
                .writer(employmentInformationApiWriter)
                .build();
    }
}
