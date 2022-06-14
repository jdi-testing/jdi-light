package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface IPositionAssert<A> extends HasAssert<A> {

    @JDIAction("Assert that '{name}' has position '{0}'")
    A position(Position position);

}
