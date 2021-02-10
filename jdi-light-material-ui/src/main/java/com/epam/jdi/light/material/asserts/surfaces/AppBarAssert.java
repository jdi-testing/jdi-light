package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.AppBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert extends UIAssert<AppBarAssert, AppBar> {

    @JDIAction("Assert that menu '{name}' is enabled")
    public AppBarAssert isEnabledMenu() {
        jdiAssert(element().isButtonMenuEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that login '{name}' is enabled")
    public AppBarAssert isEnabledLogin() {
        jdiAssert(element().isLoginEnabled(), Matchers.is(true));
        return this;
    }
}
