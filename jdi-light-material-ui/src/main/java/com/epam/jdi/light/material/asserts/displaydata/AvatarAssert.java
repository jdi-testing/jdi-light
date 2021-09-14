package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> {

    @JDIAction("Assert that avatar {name} is displayed")
    public AvatarAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that avatar {name} has photo")
    public AvatarAssert photo() {
        jdiAssert(element().hasPhoto(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that avatar {name} has no photo")
    public AvatarAssert noPhoto() {
        jdiAssert(element().hasPhoto(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that avatar {name} has a special badge")
    public AvatarAssert badge() {
        jdiAssert(element().hasBadge(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that avatar {name} has an icon")
    public AvatarAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that avatar {name} text is '{0}'")
    public AvatarAssert text(String text) {
        jdiAssert(element().core().getText(), Matchers.is(text));
        return this;
    }
}
