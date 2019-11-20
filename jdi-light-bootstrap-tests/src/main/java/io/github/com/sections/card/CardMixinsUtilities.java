package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardMixinsUtilities extends Card {
    @UI(".card-header")
    public Text header;
    @UI(".card-footer")
    public Text footer;
    @UI(".card-title")
    public Text title;
    @UI(".card-text")
    public Text text;
}
