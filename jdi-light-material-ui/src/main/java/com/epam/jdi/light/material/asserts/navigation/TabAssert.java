package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Tab;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TabAssert extends UIAssert<TabAssert, Tab> {

    @JDIAction("Assert that '{name}' is enabled")
    public TabAssert enabled(int index) {
        jdiAssert(element().isTabEnabled(index), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public TabAssert enabled(String text) {
        jdiAssert(element().isTabEnabled(text), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public TabAssert disabled(int index) {
        jdiAssert(element().isTabDisabled(index), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public TabAssert disabled(String text) {
        jdiAssert(element().isTabDisabled(text), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public TabAssert selected(int index) {
        jdiAssert(element().isTabSelected(index), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public TabAssert selected(String text) {
        jdiAssert(element().isTabSelected(text), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public TabAssert backScrollButtonEnabled() {
        boolean isEnabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isBackScrollButtonEnabled());
        jdiAssert(isEnabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public TabAssert forwardScrollButtonEnabled() {
        boolean isEnabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isForwardScrollButtonEnabled());
        jdiAssert(isEnabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public TabAssert backScrollButtonDisabled() {
        boolean isDisabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isBackScrollButtonDisabled());
        jdiAssert(isDisabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public TabAssert forwardScrollButtonDisabled() {
        boolean isDisabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isForwardScrollButtonDisabled());
        jdiAssert(isDisabled, Matchers.is(true));
        return this;
    }
}
