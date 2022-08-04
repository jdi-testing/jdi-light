package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.banners.Banner;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BannerAssert extends UIAssert<BannerAssert, Banner> {

    @JDIAction("Assert that '{name}' alert has expected text '{0}'")
    public BannerAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
