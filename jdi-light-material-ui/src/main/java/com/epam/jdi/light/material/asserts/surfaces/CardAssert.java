package com.epam.jdi.light.material.asserts.surfaces;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Card;
import org.hamcrest.Matchers;

public class CardAssert extends UIAssert<CardAssert, Card> {

    @JDIAction("Assert that '{name}' background clickable")
    public CardAssert backgroundClickable() {
        jdiAssert(element().isBackgroundClickable(), Matchers.is(true));
        return this;
    }

}
