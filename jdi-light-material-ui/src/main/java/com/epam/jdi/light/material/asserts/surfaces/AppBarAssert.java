package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.material.elements.surfaces.AppBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.common.JDIAction;

public class AppBarAssert  extends UIAssert<AppBarAssert, AppBar> {
    @JDIAction("Assert that {name} is visible")
    @Override
    public AppBarAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public AppBarAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }
}
