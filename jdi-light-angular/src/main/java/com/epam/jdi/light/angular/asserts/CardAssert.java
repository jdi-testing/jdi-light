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
    public CardAssert altImageAttribute(int imageNumber, String value) {
        jdiAssert(element().image(imageNumber).alt().contains(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' src image attribute has text '{0}'", isAssert = true)
    public CardAssert srcImageAttribute(int imageNumber, String value) {
        jdiAssert(element().image(imageNumber).src().contains(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alt image attribute has text '{0}'", isAssert = true)
    public CardAssert headerImageWithSrcAttribute(int imageNumber, String src) {
        jdiAssert(element().cartHeaderImage(imageNumber).src().contains(src), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
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
                "Card actions are in start align position");
        return this;
    }

    @JDIAction("Assert that '{name}' has align start actions")
    public CardAssert alignStartActions() {
        jdiAssert(element().actionsEndAlign(), Matchers.is(false),
                "Card actions are in end align position");
        return this;
    }

    @JDIAction("Assert that {name} has image with '{1}' height and '{2}' width")
    public CardAssert imageSize(int imageNumber, int height, int width) {
        jdiAssert(element().image(imageNumber).height(), Matchers.equalTo(height), "HEIGHT IS DIFFERENT");
        jdiAssert(element().image(imageNumber).width(), Matchers.equalTo(width), "WIDTH IS DIFFERENT");
        return this;
    }

    @JDIAction("Assert that {name} has header image with '{1}' height and '{2}' width")
    public CardAssert headerImageSize(int imageNumber, int height, int width) {
        jdiAssert(element().cartHeaderImage(imageNumber).height(), Matchers.equalTo(height), "HEIGHT IS DIFFERENT");
        jdiAssert(element().cartHeaderImage(imageNumber).width(), Matchers.equalTo(width), "WIDTH IS DIFFERENT");
        return this;
    }

    @JDIAction("Assert that {name} has image '{1}' size")
    public CardAssert headerImageSize(int imageNumber, CardImageSize size) {
        final CardImageSize actualCardImageSize = element().cardHeaderImageSize(imageNumber);
        jdiAssert(actualCardImageSize, Matchers.is(size));
        return this;
    }
}
