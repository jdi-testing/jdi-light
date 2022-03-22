package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Adornment;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AdornmentAssert extends UIAssert<AdornmentAssert, Adornment> {

    @JDIAction("Assert that '{name}'s adornment has text '{0}'")
    public AdornmentAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s adornment has position '{0}'")
    public AdornmentAssert position(Position position) {
        jdiAssert(element().position(), Matchers.is(position));
        return this;
    }

}
