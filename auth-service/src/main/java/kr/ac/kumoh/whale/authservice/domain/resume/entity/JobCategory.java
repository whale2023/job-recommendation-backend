package kr.ac.kumoh.whale.authservice.domain.resume.entity;

public enum JobCategory {
    SOFTWARE_ENGINEER("Software Engineer"),
    PRODUCT_MANAGER("Product Manager"),
    DATA_SCIENTIST("Data Scientist"),
    MARKETING_SPECIALIST("Marketing Specialist"),
    FINANCIAL_ANALYST("Financial Analyst");

    private final String displayName;

    JobCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
