package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Card;
import com.epam.jdi.light.angular.elements.enums.CardImageSize;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CardAssert extends UIAssert<CardAssert, Card> {

    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public CardAssert cardText(String value) {
        jdiAssert(element().getCardText().equals(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alt image attribute has text '{0}'", isAssert = true)
    public CardAssert altImageAttribute(String value) {
        jdiAssert(element().bodyImage().alt().contains(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' src image attribute has text '{0}'", isAssert = true)
    public CardAssert srcImageAttribute(String value) {
        jdiAssert(element().bodyImage().src().contains(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alt image attribute has text '{0}'", isAssert = true)
    public CardAssert headerImageWithSrcAttribute(int imageNumber, String src) {
        jdiAssert(element().headerImage().src().contains(src), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' buttons", isAssert = true)
    public CardAssert numberOfButtonsOnCard(int number) {
        jdiAssert(element().actionButtons().size() == number, Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has align end actions")
    public CardAssert alignEndActions() {
        jdiAssert(element().actionsEndAlign(), Matchers.is(true),
                "Card actions are in end align position");
        return this;
    }

    @JDIAction("Assert that '{name}' has align start actions")
    public CardAssert alignStartActions() {
        jdiAssert(element().actionsEndAlign(), Matchers.is(false),
                "Card actions are in start align position");
        return this;
    }

    @JDIAction("Assert that {name} has image with '{1}' height and '{2}' width")
    public CardAssert imageSize(int height, int width) {
        jdiAssert(element().bodyImage().height(), Matchers.equalTo(height));
        jdiAssert(element().bodyImage().width(), Matchers.equalTo(width));
        return this;
    }

    @JDIAction("Assert that {name} has header image with '{1}' height and '{2}' width")
    public CardAssert headerImageSize(int height, int width) {
        jdiAssert(element().headerImage().height(), Matchers.equalTo(height));
        jdiAssert(element().headerImage().width(), Matchers.equalTo(width));
        return this;
    }

    @JDIAction("Assert that {name} has image '{1}' size")
    public CardAssert headerImageSize(CardImageSize size) {
        final CardImageSize actualCardImageSize = element().cardHeaderImageSize();
        jdiAssert(actualCardImageSize, Matchers.is(size));
        return this;
    }
}
