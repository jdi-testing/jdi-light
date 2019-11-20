package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardStyled extends Card {
    @UI(".card-header")
    public Text header;
    @UI(".card-title")
    public Text title;
    @UI(".card-text")
    public Text body;
}
