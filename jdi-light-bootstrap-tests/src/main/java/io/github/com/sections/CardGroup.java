package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CardGroup extends Card {

    @UI(".card:nth-of-type(1)") public Card card1;
    @UI(".card:nth-of-type(2)") public Card card2;

}
