package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.angular.elements.enums.BadgePosition;
import com.epam.jdi.light.angular.elements.enums.BadgeSize;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static java.lang.String.format;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge> {

    @JDIAction("Assert that '{name}' has '{0}' color")
    public BadgeAssert color(String value) {
        String actualColor = element().color();
        jdiAssert(actualColor, Matchers.equalTo(value), format("%s is not equal to %s", actualColor, value));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' size")
    public BadgeAssert size(BadgeSize size) {
        final BadgeSize actualBadgeSize = element().size();
        jdiAssert(actualBadgeSize, Matchers.is(size), format("%s is not equal to %s", actualBadgeSize, size));
        return this;

    }

    @JDIAction("Assert that '{name}' has '{0}' position (vertical)")
    public BadgeAssert positionVertical(BadgePosition value) {
        final BadgePosition actualPosition = element().positionVertical();
        jdiAssert(actualPosition, Matchers.is(value), format("%s is not equal to %s", actualPosition, value));
        return this;

    }

    @JDIAction("Assert that '{name}' has '{0}' position (horizontal)")
    public BadgeAssert positionHorizontal(BadgePosition value) {
        final BadgePosition actualPosition = element().positionHorizontal();
        jdiAssert(actualPosition, Matchers.is(value), format("%s is not equal to %s", actualPosition, value));
        return this;

    }

    @JDIAction("Assert that '{name}' is overlap: {0}")
    public BadgeAssert overlap(boolean value) {
        jdiAssert(element().isOverlap(), Matchers.is(value), value ? "should be overlap" : "should NOT be overlap");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public BadgeAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "should be displayed");
        return super.displayed();
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public BadgeAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "should be enabled");
        return super.enabled();
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public BadgeAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "should be disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' has text {0}")
    public BadgeAssert text(String value) {
        final String actualText = element().getText();
        jdiAssert(actualText, Matchers.is(value), format("%s is not equal to %s", actualText, value));
        return this;
    }
}
