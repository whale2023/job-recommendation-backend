package kr.ac.kumoh.whale.authservice.domain.member.dto;

import kr.ac.kumoh.whale.authservice.domain.member.entity.Disability;
import kr.ac.kumoh.whale.authservice.domain.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String username;
    private int age;
    private String email;
    private String encryptedPwd;
    private String addressInfo;
    private String addressDetails;
    private Disability disabilityType;

    public MemberDto(MemberEntity memberEntity) {
        this.username = memberEntity.getUsername();
        this.email = memberEntity.getEmail();
        this.age = memberEntity.getAge();
        this.encryptedPwd = memberEntity.getEncryptedPwd();
        this.addressInfo = memberEntity.getAddressInfo();
        this.addressDetails = memberEntity.getAddressDetails();
        this.disabilityType = memberEntity.getDisabilityType();
    }
}
