package io.github.com.sections.card;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CardDeckSection extends Section {
    @UI(".card:nth-of-type(1)")
    public CardGrouped card1;
    @UI(".card:nth-of-type(2)")
    public CardGrouped card2;
}
