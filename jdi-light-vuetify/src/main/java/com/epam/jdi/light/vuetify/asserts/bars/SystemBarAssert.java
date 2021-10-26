package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SystemBarAssert extends BasicBarAssert<SystemBar, SystemBarAssert> {

    @JDIAction("Assert that '{name}' has expected background color")
    public SystemBarAssert backgroundColor(String color) {
        jdiAssert(element().hasBackgroundColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected position")
    public SystemBarAssert position(String position) {
        jdiAssert(element().hasPosition(), Matchers.containsString(position));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected time")
    public SystemBarAssert time(String time) {
        jdiAssert(element().getTime(), Matchers.containsString(time));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'Wi-Fi' icon")
    public SystemBarAssert wiFiIcon() {
        jdiAssert(element().hasWiFiIcon() ? "icon is displayed" : "icon is not displayed",
                Matchers.is("icon is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'signal' icon")
    public SystemBarAssert signalIcon() {
        jdiAssert(element().hasSignalIcon() ? "icon is displayed" : "icon is not displayed",
                Matchers.is("icon is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'battery' icon")
    public SystemBarAssert batteryIcon() {
        jdiAssert(element().hasBatteryIcon() ? "icon is displayed" : "icon is not displayed",
                Matchers.is("icon is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'message' icon")
    public SystemBarAssert messageIcon() {
        jdiAssert(element().hasMessageIcon() ? "icon is displayed" : "icon is not displayed",
                Matchers.is("icon is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'minus' icon")
    public SystemBarAssert minusIcon() {
        jdiAssert(element().hasMinusIcon() ? "icon is displayed" : "icon is not displayed",
                Matchers.is("icon is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'empty checkbox' icon")
    public SystemBarAssert emptyCheckboxIcon() {
        jdiAssert(element().hasEmptyCheckboxIcon() ? "icon is displayed" : "icon is not displayed",
                Matchers.is("icon is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'close' icon")
    public SystemBarAssert closeIcon() {
        jdiAssert(element().hasCloseIcon() ? "icon is displayed" : "icon is not displayed",
                Matchers.is("icon is displayed"));
        return this;
    }
}
