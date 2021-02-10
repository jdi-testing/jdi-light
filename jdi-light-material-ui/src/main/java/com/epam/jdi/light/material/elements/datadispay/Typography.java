package com.epam.jdi.light.material.elements.datadispay;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.datadisplay.TypographyAssert;

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
        return core().classes().stream()
                .anyMatch(styleClass -> styleClass.equals(String.format(STYLE_CLASS_PATTERN, style)));
    }
}
