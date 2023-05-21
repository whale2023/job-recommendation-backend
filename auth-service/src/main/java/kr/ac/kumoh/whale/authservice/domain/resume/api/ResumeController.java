package kr.ac.kumoh.whale.authservice.domain.resume.api;

import kr.ac.kumoh.whale.authservice.domain.resume.dto.ResumeDto;
import kr.ac.kumoh.whale.authservice.domain.resume.dto.ResumeRequest;
import kr.ac.kumoh.whale.authservice.domain.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @PostMapping
    public ResponseEntity<ResumeDto> writeResume(@RequestHeader("Authorization") String token,
                                                 @RequestBody ResumeRequest resumeRequest) {
        String accessToken = token.substring(7);
        ResumeDto response = resumeService.createResume(accessToken, resumeRequest);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<ResumeDto> getResume(@RequestHeader("Authorization") String token) {
        String accessToken = token.substring(7);
        ResumeDto response = resumeService.getResume(accessToken);

        return ResponseEntity.ok().body(response);
    }
}
