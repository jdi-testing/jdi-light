package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Card;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CardAssert extends UIAssert<CardAssert, Card> {
    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public CardAssert assertCardText(String value) {
        jdiAssert(element().getCardText().equals(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alt image attribute has text '{0}'", isAssert = true)
    public CardAssert assertAltImageAttribute(String value) {
        jdiAssert(element().getImage().getAttribute("alt").contains(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' src image attribute has text '{0}'", isAssert = true)
    public CardAssert assertSrcImageAttribute(String value) {
        jdiAssert(element().getImage().getAttribute("src").contains(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' buttons", isAssert = true)
    public CardAssert assertNumberOfButtonsOnCard(int number) {
        jdiAssert(element().getButtons().size() == number, Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
