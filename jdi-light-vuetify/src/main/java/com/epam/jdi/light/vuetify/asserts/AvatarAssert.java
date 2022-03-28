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

    /**
     * Assert for check text in {@link Avatar}.
     * It's a helper method for the default method "text" of interface ITextAssert.
     *
     * @param condition - Matcher for checking text
     * @return AvatarAssert
    */
    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public AvatarAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    /**
     * Assert for check {@link Avatar} size
     * All avatars have resolution size * size (for example, 48x48 px)
     *
     * @param size size of avatar in px.
     * @return AvatarAssert
     */
    @JDIAction("Assert that '{name}' size is {int} px")
    public AvatarAssert size(Integer size) {
        jdiAssert(element().getSize(), Matchers.is(new Dimension(size, size)));
        return this;
    }
}
