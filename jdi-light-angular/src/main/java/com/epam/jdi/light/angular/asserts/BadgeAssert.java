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
        jdiAssert(actualColor, Matchers.equalTo(value));
        return this;
    }

    @JDIAction("Assert that '{name}' has text {0}")
    public BadgeAssert text(String value) {
        final String actualText = element().getText();
        jdiAssert(actualText, Matchers.is(value));
        return this;
    }
}
