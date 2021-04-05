package com.epam.jdi.light.material.asserts.layouts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Hidden;
import org.hamcrest.Matchers;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class HiddenAssert  extends UIAssert<HiddenAssert, Hidden> {
    @JDIAction("Assert that {name} is visible")
    @Override
    public HiddenAssert visible() {
        boolean isVisible = new Timer(base().getTimeout() * 300L)
                .wait(() -> element().isVisible());
        jdiAssert(isVisible, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} isn't visible")
    @Override
    public HiddenAssert notVisible() {
        boolean isVisible = new Timer(base().getTimeout() * 300L)
                .wait(() -> element().isVisible());
        jdiAssert(isVisible, Matchers.is(false));
        return this;
    }
}
