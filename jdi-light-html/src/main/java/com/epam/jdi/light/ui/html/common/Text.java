package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.ui.html.asserts.TextAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public interface Text extends BaseFindElement<HtmlElement> {
    String getText();

    TextAssert is();
    TextAssert assertThat();
}
