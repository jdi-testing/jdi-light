package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardTextAlignment extends Card {
    @UI(".card-title")
    public Text cardTitle;
    @UI(".card-text")
    public Text cardDescription;
    @UI("button")
    public Button cardButton;
}
