package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> {

    @JDIAction("Assert that '{name}' is displayed")
    public AvatarAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public AvatarAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' size is '{0}'px")
    public AvatarAssert size(Integer size) {
        jdiAssert(element().getSize(), Matchers.is(new Dimension(size, size)));
        return this;
    }
}
