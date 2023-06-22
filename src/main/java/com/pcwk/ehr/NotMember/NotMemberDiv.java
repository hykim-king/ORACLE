package com.pcwk.ehr.NotMember;

public enum NotMemberDiv {
    DIV_1("1", "Division 1"),
    DIV_2("2", "Division 2"),
    DIV_3("3", "Division 3");

    private final String code;
    private final String label;

    NotMemberDiv(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static NotMemberDiv fromCode(String code) {
        for (NotMemberDiv div : NotMemberDiv.values()) {
            if (div.getCode().equals(code)) {
                return div;
            }
        }
        throw new IllegalArgumentException("Invalid NotMemberDiv code: " + code);
    }
}
