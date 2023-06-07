package kr.ac.kumoh.whale.authservice.domain.resume.entity;

public enum Certification {
    간호사("간호사"),
    사회복지사("사회복지사"),
    물류관리사("물류관리사"),
    무역영어("무역영어"),
    요양보호사("요양보호사"),
    보일러기능사("보일러기능사"),
    공조냉동기계기능사("공조냉동기계기능사"),
    자동차운전면허("자동차운전면허"),
    바리스타2급("바리스타 2급"),
    바리스타1급("바리스타 1급");

    private final String displayName;

    Certification(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
