package com.epam.jdi.light.angular.elements.enums;

import java.util.Arrays;

public enum BadgeSize {
    LARGE("mat-badge-large"),
    MEDIUM("mat-badge-medium"),
    SMALL("mat-badge-small"),
    UNKNOWN("unknown");

    private final String styleName;

    BadgeSize(String styleName) {
        this.styleName = styleName;
    }

    public static BadgeSize fromName(String name) {
        return Arrays.stream(BadgeSize.values())
                .filter(c -> c.styleName.equalsIgnoreCase(name))
                .findFirst()
                .orElse(BadgeSize.UNKNOWN);
    }
}
