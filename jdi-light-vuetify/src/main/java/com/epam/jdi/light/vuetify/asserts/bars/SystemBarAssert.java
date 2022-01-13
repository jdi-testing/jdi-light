package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SystemBarAssert extends BasicBarAssert<SystemBar, SystemBarAssert> {

    @JDIAction("Assert that '{name}' has expected background color")
    public SystemBarAssert backgroundColor(String color) {
        jdiAssert(element().getBackgroundColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected position")
    public SystemBarAssert position(String position) {
        jdiAssert(element().getPosition(), Matchers.containsString(position));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected time value")
    public SystemBarAssert time(String time) {
        jdiAssert(element().getTime(), Matchers.containsString(time));
        return this;
    }
}
