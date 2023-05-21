package kr.ac.kumoh.whale.authservice.domain.resume.entity;

public enum Certification {
    JAVA("Java Certification"),
    AWS("AWS Certification"),
    PMP("Project Management Professional"),
    CCNA("Cisco Certified Network Associate"),
    CFA("Chartered Financial Analyst");

    private final String displayName;

    Certification(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
