package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge> {

    @JDIAction("Assert that {name}'s child svg is visible")
    public BadgeAssert displayedSvg() {
        try {
            boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                    .wait(() -> element().find(".MuiSvgIcon-root").isDisplayed());
            jdiAssert(isDisplayed, Matchers.is(true));
        } catch (AssertionError e){
            new AssertionError("Svg not found");
        }
        return this;
    }

    @JDIAction("Assert that {name}' has proper counter value")
    public BadgeAssert counterValue(String value) {
        jdiAssert(element().getCounterValue(), Matchers.containsString(value));
        return this;
    }

    @JDIAction("Assert that {name}' has dot")
    public BadgeAssert dot() {
        jdiAssert(element().hasDot(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}' has proper icon visibility status")
    public BadgeAssert iconVisibilityStatus(String visibilityStatus) {
        jdiAssert(element().hasIconStatus(visibilityStatus), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}' has proper icon position")
    public BadgeAssert iconPosition(String iconPosition) {
        jdiAssert(element().hasIconStatus(iconPosition), Matchers.is(true));
        return this;
    }

}
