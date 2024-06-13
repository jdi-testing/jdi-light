package io.github.com.enums;

public enum ConfigurableMode {

    OVER("over"),
    SIDE("side"),
    PUSH("push");

    private final String mode;

    ConfigurableMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
