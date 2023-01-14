package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle;

public interface StyledText extends ICoreElement {
    String STYLE_CLASS_PATTERN = "MuiTypography-%s";

    @JDIAction("Get '{name}' style")
    default TypographyComponentStyle getStyle() {

        for (TypographyComponentStyle style : TypographyComponentStyle.values()) {
            String styleClass = String.format(STYLE_CLASS_PATTERN, style.getStyle());
            if (core().hasClass(styleClass)) {
                return style;
            }
        }
        return null;
    }

}
