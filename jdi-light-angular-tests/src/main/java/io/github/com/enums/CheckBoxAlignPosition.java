package io.github.com.enums;

public enum CheckBoxAlignPosition {
    BEFORE("before"),
    AFTER("after");
    private final String alignPosition;

    CheckBoxAlignPosition(String alignPosition) {
        this.alignPosition = alignPosition;
    }

    public String getAlignPosition() {
        return this.alignPosition;
    }
}
