package io.github.com.sections.card;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardListGroups extends Card {
    @UI(".card-header")
    public Label cardHeader;
    @UI(".list-group-item")
    public WebList listGroups;
}
