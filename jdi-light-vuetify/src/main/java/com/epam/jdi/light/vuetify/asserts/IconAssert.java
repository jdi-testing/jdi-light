package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconAssert extends UIAssert<IconAssert, Icon> {

    @JDIAction("Assert that '{name}' is displayed")
    public IconAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is clickable")
    public IconAssert clickable() {
        jdiAssert(element().core().isClickable() ? "is clickable" : "is not clickable",
                Matchers.is("is clickable"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected type")
    public IconAssert type(String iconType) {
        jdiAssert(element().hasType(), Matchers.is(iconType));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected height")
    public IconAssert height(Integer height) {
        jdiAssert(element().hasHeight(), Matchers.is(String.format("%spx", height)));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected width")
    public IconAssert width(Integer width) {
        jdiAssert(element().hasWidth(), Matchers.is(String.format("%spx", width)));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected color")
    public IconAssert color(String color) {
        jdiAssert(element().hasColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has alert after clicking on it")
    public IconAssert alertOnIconClick(String text) {
        jdiAssert(element().hasAlertOnIconClick(), Matchers.is(text));
        return this;
    }
}
