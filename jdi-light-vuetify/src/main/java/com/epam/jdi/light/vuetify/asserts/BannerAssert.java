package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Banner;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BannerAssert extends UIAssert<BannerAssert, Banner> {

    @JDIAction("Assert that '{name}' is displayed")
    public BannerAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text in title")
    public BannerAssert title(String title) {
        jdiAssert(element().getTitle(), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that '{name}'s alert has expected text")
    public BannerAssert alertText(String text) {
        jdiAssert(element().getAlertText(), Matchers.is(text));
        return this;
    }
}
