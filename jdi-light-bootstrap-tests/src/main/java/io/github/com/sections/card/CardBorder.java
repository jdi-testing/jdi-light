package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardBorder extends Card {
    @UI(".card-header")
    public Text border;
    @UI(".card-title")
    public Text title;
    @UI(".card-text")
    public Text body;
}
