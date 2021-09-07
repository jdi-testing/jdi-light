package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Card;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CardAssert extends UIAssert<CardAssert, Card> {

    @JDIAction("Assert that '{name}' has '{0}' buttons")
    public CardAssert assertNumberOfButtonsOnCard(int number) {
        jdiAssert(element().getActionButtons().size() == number, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' buttons")
    public CardAssert assertNumberOfButtonsOnCard2(int number) {
        jdiAssert(element().getActionButtons().size() == number, Matchers.is(true));
        return this;
    }
}
