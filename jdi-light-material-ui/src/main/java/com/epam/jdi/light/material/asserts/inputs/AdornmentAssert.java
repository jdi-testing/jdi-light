package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.utils.IPositionAssert;
import com.epam.jdi.light.material.elements.inputs.Adornment;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Adornment}
 */
public class AdornmentAssert extends UIAssert<AdornmentAssert, Adornment> implements ITextAssert<AdornmentAssert>, IPositionAssert<AdornmentAssert> {

    @Override
    @JDIAction("Assert that '{name}' adornment text {0}")
    public AdornmentAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    /**
     * Checks that the adornment has given position.
     *
     * @param position expected adornment position
     * @return this {@link AdornmentAssert} instance
     */
    @Override
    @JDIAction("Assert that '{name}' adornment has position '{0}'")
    public AdornmentAssert position(String position) {
        jdiAssert(element().position(), Matchers.is(Position.fromString(position)));
        return this;
    }
}
