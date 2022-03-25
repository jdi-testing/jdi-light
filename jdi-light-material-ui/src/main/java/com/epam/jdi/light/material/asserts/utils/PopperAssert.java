package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popper;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PopperAssert extends UIAssert<PopperAssert, Popper> implements ITextAssert<PopperAssert> {

    @JDIAction("Assert that '{name}' has position '{0}'")
    public PopperAssert position(Position position) {
        jdiAssert(element().position().equals(position)
                        ? "popper on " + position : "popper has another position",
                Matchers.is("popper on " + position));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public PopperAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }
}
