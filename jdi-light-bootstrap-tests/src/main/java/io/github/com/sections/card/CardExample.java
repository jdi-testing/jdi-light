package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardExample extends Card {
    @UI(".card-title")
    public Text title;
    @UI(".card-text")
    public Text text;
    @UI(".btn")
    public Button button;
    @UI("#bs-card-example-image")
    public Image image;
}
