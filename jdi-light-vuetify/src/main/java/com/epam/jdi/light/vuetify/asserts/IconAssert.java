package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconAssert extends UIAssert<IconAssert, Icon> {

    @JDIAction("Assert that {name} is displayed")
    public IconAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} text is '{0}'")
    public IconAssert text(String text) {
        jdiAssert(element().core().firstChild().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} size is '{0}'px")
    public IconAssert size(String text) {
        jdiAssert(element().properSize(), Matchers.is(String.format("height: %1$spx; min-width: %1$spx; width: %1$spx;", text)));
        return this;
    }

    @JDIAction("Assert that {name} has an icon inside of it")
    public IconAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has a photo")
    public IconAssert photo() {
        jdiAssert(element().hasPhoto(), Matchers.is("img"));
        return this;
    }
}
