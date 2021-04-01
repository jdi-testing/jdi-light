package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.datadisplay.Icons;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconsAssert extends UIAssert<IconsAssert, Icons> {
    @JDIAction("Assert that {name} is visible")
    @Override
    public IconsAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has class {className}")
    public IconsAssert hasClass(String className){
        jdiAssert(element().hasClass(className), Matchers.is(true));
        return this;
    }
}

