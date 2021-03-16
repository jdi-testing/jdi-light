package com.epam.jdi.light.material.asserts.utils;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popper;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

public class PopperAssert extends UIAssert<PopperAssert, Popper> {

    @JDIAction("Assert that popper is displayed")
    public PopperAssert popperDisplayed() {
        jdiAssert(element().isPopperDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that popper is placed correctly")
    public PopperAssert popperPosition(Position position) {
        jdiAssert(position.getPosition().equals(element().getPopperPosition()),
            Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that popper text is correct")
    public PopperAssert popperTextCorrect(String text) {
        jdiAssert(element().getPopperText(), Matchers.equalTo(text));
        return this;
    }

}
