package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.utils.PositionAssert;
import com.epam.jdi.light.material.elements.inputs.Adornment;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Adornment}
 */
public class AdornmentAssert extends PositionAssert<AdornmentAssert, Adornment> implements ITextAssert<AdornmentAssert> {

    @Override
    @JDIAction("Assert that '{name}' adornment text {0}")
    public AdornmentAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
