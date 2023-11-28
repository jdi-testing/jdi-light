package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Card;
import com.epam.jdi.light.angular.elements.enums.CardImageSize;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CardAssert extends UIAssert<CardAssert, Card> {
    @JDIAction("Assert that '{name}' has text '{0}'")
    public CardAssert cardText(String value) {
        jdiAssert(element().getCardText().equals(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' alt image attribute has text '{0}'")
    public CardAssert altImageAttribute(String value) {
        jdiAssert(element().getImage().getAttribute("alt").contains(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' src image attribute has text '{0}'")
    public CardAssert srcImageAttribute(String value) {
        jdiAssert(element().getImage().getAttribute("src").contains(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' buttons")
    public CardAssert numberOfButtonsOnCard(int number) {
        jdiAssert(element().getButtons().size() == number, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has align end actions")
    public CardAssert alignEndActions() {
        jdiAssert(element().actionsEndAlign(), Matchers.is(true),
            "Card actions are in start align position");
        return this;
    }

    @JDIAction("Assert that '{name}' has align start actions")
    public CardAssert aligStartActions() {
        jdiAssert(element().actionsEndAlign(), Matchers.is(false),
            "Card actions are in end align position");
        return this;
    }

    @JDIAction("Assert that {name} has image '{0}' size")
    public CardAssert cardImageSize( CardImageSize size) {
        final CardImageSize actualCardImageSize = element().cardImageSize();
        jdiAssert(actualCardImageSize, Matchers.is(size));
        return this;
    }
}
