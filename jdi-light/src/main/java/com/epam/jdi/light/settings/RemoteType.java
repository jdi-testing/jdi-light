package com.epam.jdi.light.settings;

import java.util.Arrays;

public enum RemoteType {
    BROWSERSTACK("browserstack"),
    SAUCE("sauce"),
    SAUCE_LABS("saucelabs"),
    SELENOID("selenoid");

    private final String remoteType;

    RemoteType(String remoteType) {
        this.remoteType = remoteType;
    }

    public static RemoteType byText(String text) {
        return Arrays.stream(RemoteType.values())
                .filter(type -> type.remoteType.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("remoteType=" + text + " is not supported."));
    }
}
