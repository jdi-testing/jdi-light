package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

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
        jdiAssert(element().firstChild().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' size is '{0}'px")
    public AvatarAssert size(String size) {
        jdiAssert(element().hasSize(), Matchers.is(String.format("height: %1$spx; min-width: %1$spx; width: %1$spx;", size)));
        return this;
    }

    @JDIAction("Assert that '{name}' has an icon inside of it")
    public AvatarAssert icon() {
        jdiAssert(element().hasIcon() ? "has icon" : "does not have icon", Matchers.is("has icon"));
        return this;
    }

    @JDIAction("Assert that '{name}' has photo")
    public AvatarAssert photo() {
        jdiAssert(element().hasPhoto() ? "has photo" : "does not have photo", Matchers.is("has photo"));
        return this;
    }
}
