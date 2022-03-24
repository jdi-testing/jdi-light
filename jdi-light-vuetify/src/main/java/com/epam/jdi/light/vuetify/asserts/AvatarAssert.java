package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> implements ITextAssert<AvatarAssert> {

    @JDIAction("Assert that 'name' text {0}")
    public AvatarAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' size is '{0}'px")
    public AvatarAssert size(Integer size) {
        jdiAssert(element().getSize(), Matchers.is(new Dimension(size, size)));
        return this;
    }
}
