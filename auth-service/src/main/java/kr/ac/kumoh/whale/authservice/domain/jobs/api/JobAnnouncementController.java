package kr.ac.kumoh.whale.authservice.domain.jobs.api;

import kr.ac.kumoh.whale.authservice.domain.jobs.dto.JobAnnouncementDto;
import kr.ac.kumoh.whale.authservice.domain.jobs.service.JobAnnouncementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
@RequiredArgsConstructor
@Slf4j
public class JobAnnouncementController {
    private final JobAnnouncementService jobAnnouncementService;

    @GetMapping("")
    public ResponseEntity<List<JobAnnouncementDto>> getJobAnnouncement (@RequestHeader("Authorization")String token, Pageable pageable){
        String accessToken = token.substring(7);
        List<JobAnnouncementDto> jobAnnouncementDtos = jobAnnouncementService.getAnnouncementPage(pageable, accessToken);

        return ResponseEntity.ok().body(jobAnnouncementDtos);
    }

    @PostMapping("/wish")
    public ResponseEntity<?> addWishList(@RequestHeader("Authorization")String token, @RequestParam Long jobAnnoucemnetId) {
        String accessToken = token.substring(7);
        jobAnnouncementService.addToWishlist(accessToken, jobAnnoucemnetId);

        return ResponseEntity.ok().body("성공");
    }

    @DeleteMapping("/wish")
    public ResponseEntity<?> cancleWishList(@RequestHeader("Authorization")String token, @RequestParam Long jobAnnoucemnetId) {
        String accessToken = token.substring(7);
        jobAnnouncementService.removeFromWishlist(accessToken, jobAnnoucemnetId);

        return ResponseEntity.ok().body("성공");
    }

    @GetMapping("/wish")
    public ResponseEntity<?> getWishList(@RequestHeader("Authorization")String token, @RequestParam Long jobAnnoucemnetId) {
        String accessToken = token.substring(7);
        jobAnnouncementService.removeFromWishlist(accessToken, jobAnnoucemnetId);

        return ResponseEntity.ok().body("성공");
    }
}
