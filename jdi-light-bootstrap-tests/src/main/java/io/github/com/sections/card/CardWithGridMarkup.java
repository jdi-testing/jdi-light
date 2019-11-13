package io.github.com.sections.card;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Card;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class CardWithGridMarkup extends Card {
    @Title
    @UI(".card-title")
    public Text title;

    @UI(".card-body p")
    public Text paragraph;

    @UI("button")
    public Button button;

    @UI(".row .col-sm-6")
    public JList<CardWithHeaderAndFooter> listCard;

}
