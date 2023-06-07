package kr.ac.kumoh.whale.authservice.domain.member.entity;

import kr.ac.kumoh.whale.authservice.domain.jobs.entity.JobAnnouncement;
import kr.ac.kumoh.whale.authservice.domain.resume.entity.ResumeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @Enumerated(value = EnumType.STRING)
    private Disability disabilityType;

    @OneToOne(mappedBy = "member")
    private ResumeEntity resume;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "member_wishlist",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "job_announcement_id")
    )
    private Set<JobAnnouncement> wishlist = new HashSet<>();

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

    public void addToWishlist(JobAnnouncement jobAnnouncement) {
        wishlist.add(jobAnnouncement);
        jobAnnouncement.getMembers().add(this);
    }

    public void removeFromWishlist(JobAnnouncement jobAnnouncement) {
        wishlist.remove(jobAnnouncement);
        jobAnnouncement.getMembers().remove(this);
    }
}
