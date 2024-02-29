package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.TypographyAssert;
import com.epam.jdi.light.material.interfaces.displaydata.StyledText;

/**
 * Represents typography MUI component on GUI.
 *
 * @see <a href="https://v4.mui.com/components/typography/">Typography MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Typography extends UIBaseElement<TypographyAssert> implements IsText, StyledText {
    @Override
    public TypographyAssert is() {
        return new TypographyAssert().set(this);
    }
}
