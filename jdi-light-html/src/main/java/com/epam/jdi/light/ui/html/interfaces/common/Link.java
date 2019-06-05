package com.epam.jdi.light.ui.html.interfaces.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.ui.html.asserts.LinkAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;

import java.net.URL;

public interface Link extends BaseFindElement<HtmlElement> {
    void click();
    String getText();
    String ref();
    URL url();
    String alt();

    LinkAssert is();
    LinkAssert assertThat();
    LinkAssert has();
    LinkAssert waitFor();
    LinkAssert shouldBe();
    LinkAssert verify();
}
