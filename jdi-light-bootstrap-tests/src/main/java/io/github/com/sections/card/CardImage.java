package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardImage extends Card {
    @UI(".card-text")
    public Text text;
    @UI("#bs-card-image")
    public Image image;
}
