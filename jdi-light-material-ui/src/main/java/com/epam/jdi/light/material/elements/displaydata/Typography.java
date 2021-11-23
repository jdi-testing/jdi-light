package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.TypographyAssert;

/**
 * To see an example of Typography web element please visit
 * https://mui.com/components/typography/
 */
public class Typography extends UIBaseElement<TypographyAssert> implements IsText {

    private static final String STYLE_CLASS_PATTERN = "MuiTypography-%s";

    public boolean hasStyleClass(String style) {
        return core().hasClass(String.format(STYLE_CLASS_PATTERN, style));
    }

    @Override
    public TypographyAssert is() {
        return new TypographyAssert().set(this);
    }
}
