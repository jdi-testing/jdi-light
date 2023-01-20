package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.utils.enums.VariantType;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

/**
 * Assertions for {@link Avatar}.
 */
public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> implements ITextAssert<AvatarAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public AvatarAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' variant is {0}")
    public AvatarAssert variant(VariantType value) {
        jdiAssert(element().variant(), equalTo(value));
        return this;
    }
}
