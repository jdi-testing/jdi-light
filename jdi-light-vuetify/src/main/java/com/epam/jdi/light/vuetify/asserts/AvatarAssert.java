package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> {

    @JDIAction("Assert that {name} is displayed")
    public AvatarAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} text is '{0}'")
    public AvatarAssert text(String text) {
        jdiAssert(element().core().firstChild().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} size is '{0}'px")
    public AvatarAssert size(String text) {
        jdiAssert(element().properSize(), Matchers.is(String.format("height: %1$spx; min-width: %1$spx; width: %1$spx;",
                text)));
        return this;
    }

    @JDIAction("Assert that {name} has an icon inside of it")
    public AvatarAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has a photo")
    public AvatarAssert photo() {
        jdiAssert(element().hasPhoto(), Matchers.is("img"));
        return this;
    }
}
