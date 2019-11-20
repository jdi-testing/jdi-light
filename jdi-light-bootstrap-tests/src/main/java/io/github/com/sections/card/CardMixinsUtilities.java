package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

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
