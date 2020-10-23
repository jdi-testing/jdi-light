package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.Card;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CardSection {

    @UI("#simple-card")
    public static Card simpleCard;

    @UI("#example-card")
    public static Card card;
}
