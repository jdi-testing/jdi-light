package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.TypographyAssert;

public class Typography extends UIBaseElement<TypographyAssert> {

    private static final String STYLE_CLASS_PATTERN = "MuiTypography-%s";

    @Override
    public TypographyAssert has() {
        return new TypographyAssert().set(this);
    }

    public String getValue() {
        return core().getText();
    }

    public boolean hasStyleClass(String style) {
        return core().hasClass(String.format(STYLE_CLASS_PATTERN, style));
    }
}
