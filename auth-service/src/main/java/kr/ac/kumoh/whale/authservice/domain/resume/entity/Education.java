package kr.ac.kumoh.whale.authservice.domain.resume.entity;

public enum Education {
    HIGH_SCHOOL("High School"),
    BACHELOR("Bachelor's Degree"),
    MASTER("Master's Degree"),
    DOCTORATE("Doctorate Degree");

    private final String displayName;

    Education(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

