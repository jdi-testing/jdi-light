package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> {

    @JDIAction("Assert that avatar '{name}' text is '{0}'")
    public AvatarAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
