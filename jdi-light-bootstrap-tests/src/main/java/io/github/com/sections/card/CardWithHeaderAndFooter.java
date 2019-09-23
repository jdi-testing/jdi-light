package io.github.com.sections.card;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardWithHeaderAndFooter extends Card {
    @Title
    @UI(".card-title")
    public Text title;

    @UI(".card-body p")
    public Text body;

    @UI("button")
    public Button button;

    @UI(".card-header")
    public Text header;

    @UI(".card-footer")
    public Text footer;
}
