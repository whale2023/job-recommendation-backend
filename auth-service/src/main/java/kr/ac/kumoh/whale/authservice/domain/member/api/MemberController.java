package kr.ac.kumoh.whale.authservice.domain.member.api;

import kr.ac.kumoh.whale.authservice.domain.member.dto.JoinMemberDto;
import kr.ac.kumoh.whale.authservice.domain.member.dto.MemberDto;
import kr.ac.kumoh.whale.authservice.domain.member.dto.response.MemberInfoDto;
import kr.ac.kumoh.whale.authservice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<MemberDto> registerMember(@RequestBody JoinMemberDto memberDto) {
        MemberDto registeredMember = memberService.createUser(memberDto);

        return ResponseEntity.ok().body(registeredMember);
    }

    @GetMapping("")
    public ResponseEntity<MemberInfoDto> getMyInfo(@RequestHeader("Authorization")String token) {
        String accessToken = token.substring(7);
        MemberInfoDto memberInfo = memberService.getMyInfo(accessToken);

        return ResponseEntity.ok().body(memberInfo);
    }
}
