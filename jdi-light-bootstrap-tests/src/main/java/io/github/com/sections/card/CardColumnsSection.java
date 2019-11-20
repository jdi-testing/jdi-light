package io.github.com.sections.card;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CardColumnsSection extends Section {
    @UI(".card:nth-of-type(1)")
    public CardWithinCardColumns topLeftCard;
    @UI(".card:nth-of-type(2)")
    public CardWithinCardColumns bottomLeftCard;
    @UI(".card:nth-of-type(3)")
    public CardWithinCardColumns topRightCard;
    @UI(".card:nth-of-type(4)")
    public CardWithinCardColumns middleRightCard;
    @UI(".card:nth-of-type(5)")
    public CardWithinCardColumns bottomRightCard;
}
