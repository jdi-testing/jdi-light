package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Banner;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BannerAssert extends UIAssert<BannerAssert, Banner> {

    @JDIAction("Assert that '{name}'s alert has expected text")
    public BannerAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
