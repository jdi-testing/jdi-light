package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SystemBarAssert extends BasicBarAssert<SystemBar, SystemBarAssert> {

    @JDIAction("Assert that {name} has proper background color")
    public SystemBarAssert backgroundColor(String color) {
        jdiAssert(element().getBackgroundColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that {name} has proper position")
    public SystemBarAssert position(String position) {
        jdiAssert(element().getPosition(), Matchers.containsString(position));
        return this;
    }

    @JDIAction("Assert that {name} has proper time")
    public SystemBarAssert time(String time) {
        jdiAssert(element().getTime(), Matchers.containsString(time));
        return this;
    }

    @JDIAction("Assert that {name} has 'Wi-Fi' icon")
    public SystemBarAssert wiFiIcon() {
        jdiAssert(element().hasWiFiIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'signal' icon")
    public SystemBarAssert signalIcon() {
        jdiAssert(element().hasSignalIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'battery' icon")
    public SystemBarAssert batteryIcon() {
        jdiAssert(element().hasBatteryIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'message' icon")
    public SystemBarAssert messageIcon() {
        jdiAssert(element().hasMessageIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'minus' icon")
    public SystemBarAssert minusIcon() {
        jdiAssert(element().hasMinusIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'empty checkbox' icon")
    public SystemBarAssert emptyCheckboxIcon() {
        jdiAssert(element().hasEmptyCheckboxIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'close' icon")
    public SystemBarAssert closeIcon() {
        jdiAssert(element().hasCloseIcon(), Matchers.is(true));
        return this;
    }
}
