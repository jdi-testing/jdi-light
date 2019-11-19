package io.github.com.sections.card;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Card;

public class CardKitchenSink extends Card {
    @UI(".card-img-top")
    public Image image;
    @UI(".card-title")
    public Text title;
    @UI(".card-text")
    public Text text;
    @UI(".card-body")
    public WebList body;
    @UI(".card-link")
    public WebList links;
    @UI(".list-group")
    public WebList list;
}
