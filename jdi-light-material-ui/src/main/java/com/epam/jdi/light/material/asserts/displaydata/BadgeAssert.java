package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge> implements ITextAssert<BadgeAssert> {

    @Override
    @JDIAction("Assert that '{name}' contains text '{0}'")
    public BadgeAssert text(String value) {
        jdiAssert(element().text(), Matchers.containsString(value));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public BadgeAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' is a dot")
    public BadgeAssert dot() {
        jdiAssert(element().isDot() ? "is a dot" : "is not a dot", Matchers.is("is a dot"));
        return this;
    }

    @JDIAction("Assert that '{name}' has position '{0}'")
    public BadgeAssert position(Position position) {
        jdiAssert(element().getPosition(), Matchers.containsStringIgnoringCase(position.toString()));
        return this;
    }

}
