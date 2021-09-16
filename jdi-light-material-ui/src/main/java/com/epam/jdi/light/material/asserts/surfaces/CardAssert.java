package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Card;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CardAssert extends UIAssert<CardAssert, Card> {

    @JDIAction("Assert that card '{name}' has title '{0}'")
    public CardAssert assertCardTitleText(String value) {
        jdiAssert(element().getHeaderTitle().text().equals(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that card '{name}' has subheader '{0}'")
    public CardAssert assertCardSubheaderText(String value) {
        jdiAssert(element().getHeaderSubheader().text().equals(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' buttons")
    public CardAssert assertNumberOfButtonsOnCard(int number) {
        jdiAssert(element().getActionButtons().size() == number, Matchers.is(true));
        return this;
    }
}
