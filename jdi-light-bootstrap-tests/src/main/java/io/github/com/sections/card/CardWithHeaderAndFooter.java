package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardWithHeaderAndFooter extends Card {
    @UI(".card-title")
    public Text title;
    @UI(".card-body p")
    public Text paragraph;
    @UI("button")
    public Button button;
    @UI(".card-header")
    public Text header;
    @UI("//*[contains(@class, 'footer')]")
    public Text footer;
}
