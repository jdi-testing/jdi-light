package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class CardWithSubtitlesAndLinks extends Card {
    @UI(".card-title")
    public Text title;
    @UI(".card-subtitle")
    public Text subtitle;
    @UI(".card-text")
    public Text mainText;
    @UI("#bs-card-2-link1")
    public Link link1;
    @UI("#bs-card-2-link2")
    public Link link2;
}
