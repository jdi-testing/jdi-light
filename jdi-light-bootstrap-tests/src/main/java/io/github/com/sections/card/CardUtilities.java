package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardUtilities extends Card {
    @UI(".card-title")
    public Text cardTitle;
    @UI(".card-text")
    public Text cardText;
    @UI(".btn")
    public Button cardButton;
}
