package org.project.dalantbook.domain.enums;

public enum UserPosition {
    PASTOR("PASTOR", "목사"),
    ASSISTANT_PASTOR("ASSISTANT_PASTOR", "부목사"),
    PROBATION_PASTOR("PROBATION_PASTOR", "강도사"),
    JUNIOR_PASTOR("JUNIOR_PASTOR", "전도사"),
    MISSIONARY("MISSIONARY", "선교사"),
    ELDER("ELDER", "장로 및 권사"),
    DEACON("DEACON", "집사"),
    LAY_MAN("LAY_MAN", "평신도");

    private String korName;
    private String engName;

    UserPosition(String engName, String korName) {
        this.engName = engName;
        this.korName = korName;
    }
}


