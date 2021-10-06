package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconAssert extends UIAssert<IconAssert, Icon> {

    @JDIAction("Assert that {name} is displayed")
    public IconAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is displayed")
    public IconAssert clickable() {
        jdiAssert(element().core().isClickable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has proper type")
    public IconAssert type(String text) throws Exception {
        jdiAssert(element().getType(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} has proper height")
    public IconAssert height(String height) {
        jdiAssert(element().getHeight(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that {name} has proper width")
    public IconAssert width(String width) {
        jdiAssert(element().getWidth(), Matchers.is(width));
        return this;
    }

    @JDIAction("Assert that {name} has proper color")
    public IconAssert color(String color) {
        jdiAssert(element().getColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that banner has alert after clicking on icon")
    public IconAssert alertOnIconClick(String text) {
        jdiAssert(element().hasAlertOnIconClick(), Matchers.is(text));
        return this;
    }
}
