package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> {

    @JDIAction("Assert that avatar '{name}' has photo")
    public AvatarAssert image() {
        jdiAssert(element().hasImage() ? "has image" : "does not have image", Matchers.is("has image"));
        return this;
    }

    @JDIAction("Assert that avatar '{name}' has no photo")
    public AvatarAssert noImage() {
        jdiAssert(!element().hasImage() ? "does not have image" : "has image", Matchers.is("does not have image"));
        return this;
    }

    @JDIAction("Assert that avatar '{name}' has a special badge")
    public AvatarAssert badge() {
        jdiAssert(element().hasBadge() ? "has badge" : "does not have badge", Matchers.is("has badge"));
        return this;
    }

    @JDIAction("Assert that avatar '{name}' has an icon")
    public AvatarAssert icon() {
        jdiAssert(element().hasIcon() ? "has icon" : "does not have icon", Matchers.is("has icon"));
        return this;
    }

    @JDIAction("Assert that avatar '{name}' text is '{0}'")
    public AvatarAssert text(String text) {
        jdiAssert(element().core().getText(), Matchers.is(text));
        return this;
    }
}
