package io.github.com.custom.cards;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Text;

public class RevealCard extends Card {

    @UI("div.text--primary")
    private Text primaryText;

    @UI("button")
    private Button learnMoreButton;

    @Override
    public Text title() {
        return new Text().setCore(Text.class, core().find(".text-h4"));
    }

    public Text getPrimaryText() {
        return primaryText;
    }

    public Button getLearnMoreButton() {
        return learnMoreButton;
    }

    public Card getReveal() {
        return new Card().setCore(Card.class, this.find("//div[contains(@class, 'transition')]"));
    }

    public Button getCloseButton() {
        return new Button().setCore(Button.class, this.find("//button[./span[contains(text(), 'Close')]]"));
    }
}
