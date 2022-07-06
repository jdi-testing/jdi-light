package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Badge;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge> {
    @JDIAction("Assert that number of new messages is displayed on the '{name}'")
    public BadgeAssert newMessages() {
        jdiAssert(element().getDigits() == -1, Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that number of new messages on the '{name}' is '{0}'")
    public BadgeAssert numberOfNewMessages(Integer number) {
        jdiAssert(element().getDigits(), Matchers.is(number));
        return this;
    }

    @JDIAction("Assert that text on the '{name}' is '{0}'")
    public BadgeAssert text(String text) {
        jdiAssert(element().getText(), Matchers.equalToIgnoringCase(text));
        return this;
    }
}
