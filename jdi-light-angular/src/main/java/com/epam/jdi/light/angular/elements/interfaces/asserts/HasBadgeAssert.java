package com.epam.jdi.light.angular.elements.interfaces.asserts;

import com.epam.jdi.light.angular.elements.enums.BadgePosition;
import com.epam.jdi.light.angular.elements.enums.BadgeSize;
import com.epam.jdi.light.angular.elements.interfaces.HasBadge;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface HasBadgeAssert<A, E extends HasBadge> extends IBaseAssert<E> {
    @JDIAction("Assert that '{name}' badge has '{0}' size")
    default A badgeSize(BadgeSize size) {
        final BadgeSize actualBadgeSize = element().badgeSize();
        jdiAssert(actualBadgeSize, Matchers.is(size));
        return (A) this;

    }

    @JDIAction("Assert that '{name}' badge has '{0}' vertical position")
    default A badgePositionVertical(BadgePosition value) {
        final BadgePosition actualPosition = element().badgePositionVertical();
        jdiAssert(actualPosition, Matchers.is(value));
        return (A) this;

    }

    @JDIAction("Assert that '{name}' badge has '{0}' horizontal position")
    default A badgePositionHorizontal(BadgePosition value) {
        jdiAssert(element().badgePositionHorizontal(), Matchers.is(value));
        return (A) this;

    }

    @JDIAction("Assert that '{name}' badge is overlap: {0}")
    default A badgeOverlap(boolean value) {
        jdiAssert(element().isBadgeOverlap(), Matchers.is(value), value ? "should be overlap" : "should NOT be overlap");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' badge is displayed")
    default A badgeDisplayed() {
        jdiAssert(element().isBadgeDisplayed(), Matchers.is(true), "Element's badge is not displayed");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' badge is enabled")
    default A badgeEnabled() {
        jdiAssert(element().isBadgeEnabled(), Matchers.is(true), "Element's badge is not enabled");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' badge is disabled")
    default A badgeDisabled() {
        jdiAssert(element().isBadgeDisabled(), Matchers.is(true), "Element's badge is not disabled");
        return (A) this;
    }
}
