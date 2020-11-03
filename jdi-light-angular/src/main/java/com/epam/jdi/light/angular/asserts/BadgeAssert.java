package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BadgeAssert  extends UIAssert<BadgeAssert, Badge> {

    @JDIAction("'{name}' has '{0}' color")
    public BadgeAssert color(String value) {
        jdiAssert(element.color(value), Matchers.is(true));
        return this;
    }
}
