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

    @JDIAction("Assert that '{name}' badge has icon with given class value '{0}'")
    public BadgeAssert icon(String classValue) {
        element().icon().is().classValue(Matchers.containsString(classValue));
        return this;
    }

    @JDIAction("Assert that '{name}' badge is dot")
    public BadgeAssert dot() {
        jdiAssert(element().isDot() ? "is dot" : "is not dot", Matchers.is("is dot"));
        return this;
    }

    @JDIAction("Assert that type of the '{name}' is '{0}'")
    public BadgeAssert type(String type) {
        jdiAssert(element().type(), Matchers.is(type));
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

    @JDIAction("Assert that '{name}' is bordered")
    public BadgeAssert bordered() {
        jdiAssert(element().isBordered() ? "is bordered" : "is not bordered", Matchers.is("is bordered"));
        return this;
    }

    @JDIAction("Assert that '{name}' is inline")
    public BadgeAssert inline() {
        jdiAssert(element().isInline() ? "is inline" : "is not inline", Matchers.is("is inline"));
        return this;
    }

    @JDIAction("Assert that '{name}' is bottom")
    public BadgeAssert bottom() {
        jdiAssert(element().isBottom() ? "is bottom" : "is not bottom", Matchers.is("is bottom"));
        return this;
    }

    @JDIAction("Assert that '{name}' is left")
    public BadgeAssert left() {
        jdiAssert(element().isLeft() ? "is left" : "is not left", Matchers.is("is left"));
        return this;
    }

    @JDIAction("Assert that '{name}' is overlap")
    public BadgeAssert overlap() {
        jdiAssert(element().isOverlap() ? "is overlap" : "is not overlap", Matchers.is("is overlap"));
        return this;
    }
}
