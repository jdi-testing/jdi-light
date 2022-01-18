package com.epam.jdi.light.material.asserts.utils;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popper;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

public class PopperAssert extends UIAssert<PopperAssert, Popper> {

    @JDIAction("Assert that {name} is placed correctly")
    public PopperAssert position(Position position) {
        jdiAssert(position.getPosition().equals(element().position())
                        ? "popper on " + position : "popper has another position",
                Matchers.is("popper on " + position));
        return this;
    }

    @JDIAction("Assert that {name} text is correct")
    public PopperAssert text(String text) {
        jdiAssert(element().text(), Matchers.equalTo(text));
        return this;
    }

}
