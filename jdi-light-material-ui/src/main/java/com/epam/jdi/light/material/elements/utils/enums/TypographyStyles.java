package com.epam.jdi.light.material.elements.utils.enums;

public enum TypographyStyles {
    HEAD_1("h1"),
    HEAD_2("h2"),
    HEAD_3("h3"),
    HEAD_4("h4"),
    HEAD_5("h5"),
    HEAD_6("h6"),
    SUBTITLE_1("subtitle1"),
    SUBTITLE_2("subtitle2"),
    BODY_1("body1"),
    BODY_2("body2"),
    BUTTON("button"),
    CAPTION("caption"),
    OVERLINE("overline");

    String style;

    public String getStyle() {
        return style;
    }

    TypographyStyles(String style) {
        this.style = style;
    }
}