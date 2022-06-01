package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.TypographyAssert;
import com.epam.jdi.light.material.elements.utils.enums.TypographyStyle;

/**
 * Represents typography MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/typography/">Typography MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Typography extends UIBaseElement<TypographyAssert> implements IsText {

    private static final String STYLE_CLASS_PATTERN = "MuiTypography-%s";

    /**
     * Gets the style of typography
     *
     * @return style of this typography as {@link TypographyStyle} if this style is exist, otherwise {@code null}
     */
    @JDIAction("Get '{name}' style")
    public TypographyStyle getStyle() {
        for (TypographyStyle style : TypographyStyle.values()) {
            String styleClass = String.format(STYLE_CLASS_PATTERN, style.getStyle());
            if (core().hasClass(styleClass)) {
                return style;
            }
        }
        return null;
    }

    @Override
    public TypographyAssert is() {
        return new TypographyAssert().set(this);
    }
}
