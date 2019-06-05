package com.epam.jdi.light.ui.html.interfaces.common;

import com.epam.jdi.light.asserts.IHasAssert;
import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.light.ui.html.aserts.TextAssert;

public interface Text extends IBaseElement, IHasAssert<TextAssert> {
    String getText();

}
