package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.TypographyAssert;
import com.epam.jdi.light.material.elements.utils.enums.TypographyStyle;

/**
 * To see an example of Typography web element please visit
 * https://mui.com/components/typography/
 */
public class Typography extends UIBaseElement<TypographyAssert> implements IsText {

    private static final String STYLE_CLASS_PATTERN = "MuiTypography-%s";

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
