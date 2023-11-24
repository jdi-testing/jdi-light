package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.Card;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CardPage extends NewAngularPage {
    @UI("#simple-card")
    public static Card simpleCard;

    @UI("#example-card")
    public static Card card;
}
