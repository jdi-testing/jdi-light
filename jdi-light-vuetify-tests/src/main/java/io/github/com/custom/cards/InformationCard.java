package io.github.com.custom.cards;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Text;

public class InformationCard extends Card {

    @UI("div.text--primary")
    protected Text primaryText;

    public Text primaryText() {
        return primaryText;
    }

    @Override
    public Text title() {
        return new Text().setCore(Text.class, core().find(".text-h4"));
    }

    public Button button() {
        return new Button().setCore(Button.class, actions().find("button"));
    }
}
