package io.github.com.enums;

public enum BannerButtons {

    CONNECTION_SETTINGS("CONNECTION SETTINGS"),
    DISMISS("DISMISS"),
    RETRY("RETRY"),
    ACTION("ACTION");

    private final String value;

    BannerButtons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
