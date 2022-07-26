package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Badge;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge> {
    @JDIAction("Assert that text on the '{name}' is '{0}'")
    public BadgeAssert text(String text) {
        jdiAssert(element().body().getText(), Matchers.equalToIgnoringCase(text));
        return this;
    }

    @JDIAction("Assert that badge has icon")
    public BadgeAssert icon(String classValue) {
        element().icon().is().classValue(Matchers.containsString(classValue));
        return this;
    }

    @JDIAction("Assert that badge is dot")
    public BadgeAssert dot() {
        jdiAssert(element().hasDot(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that type of the '{name}' is '{0}'")
    public BadgeAssert type(String type) {
        jdiAssert(element().getType(), Matchers.is(type));
        return this;
    }

    @JDIAction("Assert that text on the '{name}' badge is '{0}'")
    public BadgeAssert badgeText(String text) {
        jdiAssert(element().badgeText(), Matchers.equalToIgnoringCase(text));
        return this;
    }

    @JDIAction("Assert that number on the '{name}' badge is '{0}'")
    public BadgeAssert badgeNumber(int number) {
        jdiAssert(element().badgeNumber(), Matchers.is(number));
        return this;
    }
}
