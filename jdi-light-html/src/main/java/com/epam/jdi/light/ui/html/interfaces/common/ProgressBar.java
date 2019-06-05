package com.epam.jdi.light.ui.html.interfaces.common;

import com.epam.jdi.light.elements.base.BaseFindElement;
import com.epam.jdi.light.ui.html.asserts.ProgressAssert;
import com.epam.jdi.light.ui.html.base.HasLabel;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public interface ProgressBar extends BaseFindElement<HtmlElement>, HasLabel {
    String value();
    String max();

    ProgressAssert is();
    ProgressAssert assertThat();
    ProgressAssert has();
    ProgressAssert waitFor();
    ProgressAssert shouldBe();
    ProgressAssert verify();
}
