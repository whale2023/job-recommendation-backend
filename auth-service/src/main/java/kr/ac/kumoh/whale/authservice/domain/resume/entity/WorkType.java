package kr.ac.kumoh.whale.authservice.domain.resume.entity;

public enum WorkType {
    FULL_TIME("Full-time"),
    PART_TIME("Part-time"),
    REMOTE("Remote");

    private final String displayName;

    WorkType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}