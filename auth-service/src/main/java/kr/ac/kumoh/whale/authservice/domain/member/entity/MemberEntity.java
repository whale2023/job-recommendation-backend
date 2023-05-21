package kr.ac.kumoh.whale.authservice.domain.member.entity;

import kr.ac.kumoh.whale.authservice.domain.resume.entity.ResumeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NonNull
    @Column(nullable = false, length = 20)
    private String username;

    @NonNull
    @Column(nullable = false)
    private int age;

    @NonNull
    @Column(nullable = false, length = 20, unique = true)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String encryptedPwd;

    @NonNull
    @Column(nullable = false,length = 100)
    private String addressInfo;

    @NonNull
    @Column(nullable = false, length = 100)
    private String addressDetails;

    @NonNull
    @Column(nullable = false)
    private Disability disabilityType;

    @OneToOne(mappedBy = "member")
    private ResumeEntity resume;

    @Builder
    public MemberEntity(@NonNull String username, @NonNull int age, @NonNull String email, @NonNull String encryptedPwd, @NonNull String addressInfo, @NonNull String addressDetails, @NonNull Disability disabilityType) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.encryptedPwd = encryptedPwd;
        this.addressInfo = addressInfo;
        this.addressDetails = addressDetails;
        this.disabilityType = disabilityType;
    }

    public void writeResume(ResumeEntity resume){
        resume.setMember(this);
    }
}
