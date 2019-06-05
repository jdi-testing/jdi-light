package com.epam.jdi.light.ui.html.interfaces.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.ui.html.asserts.ImageAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public interface Image extends BaseFindElement<HtmlElement> {
    void click();
    String src();
    String height();
    String width();
    String alt();

    ImageAssert is();
    ImageAssert assertThat();
    ImageAssert has();
    ImageAssert waitFor();
    ImageAssert shouldBe();
    ImageAssert verify();
}
