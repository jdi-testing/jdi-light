package com.epam.jdi.light.material.elements.utils.enums;

/**
 * Contains named constants representing typography style.
 * Each constant includes information about its style
 */
public enum TypographyComponentStyle {
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

    final String style;

    /**
     * Gets the style of typography
     *
     * @return style of this typography as {@link String}
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the typography style
     *
     * @param style given style
     */
    TypographyComponentStyle(String style) {
        this.style = style;
    }

    /**
     * Finds style of the typography
     *
     * @param text style of the typography to be found
     * @return style of the typography as {@link TypographyComponentStyle} if it exists, otherwise {@code null}
     */
    public static TypographyComponentStyle fromString(String text) {
        for (TypographyComponentStyle st : TypographyComponentStyle.values()) {
            if (st.style.equalsIgnoreCase(text)) {
                return st;
            }
        }
        return null;
    }
}
