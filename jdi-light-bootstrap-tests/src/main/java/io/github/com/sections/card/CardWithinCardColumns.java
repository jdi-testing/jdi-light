package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardWithinCardColumns extends Card {
    @UI(".card-title")
    public Text title;
    @UI("p:nth-of-type(1)")
    public Text mainText;
    @UI(".card-text small")
    public Text mutedText;
    @UI("footer small")
    public Text footerText;
    @UI(".card-img-top")
    public Image image;
}
