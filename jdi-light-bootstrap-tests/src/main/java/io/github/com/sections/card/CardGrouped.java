package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardGrouped extends Card {
    @UI(".card-title")
    public Text title;
    @UI(".card-text:nth-of-type(1)")
    public Text mainText;
    @UI(".card-text .text-muted")
    public Text mutedText;
    @UI(".card-img-top")
    public Image image;
    @UI(".card-footer small")
    public Text footerText;
}
