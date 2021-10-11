package com.epam.jdi.light.material.asserts.utils;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popper;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

public class PopperAssert extends UIAssert<PopperAssert, Popper> {

    @JDIAction("Assert that {name} is displayed")
    public PopperAssert popperDisplayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is placed correctly")
    public PopperAssert popperPosition(Position position) {
        jdiAssert(position.getPosition().equals(element().position()),
                Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} text is correct")
    public PopperAssert popperTextCorrect(String text) {
        jdiAssert(element().text(), Matchers.equalTo(text));
        return this;
    }

}
