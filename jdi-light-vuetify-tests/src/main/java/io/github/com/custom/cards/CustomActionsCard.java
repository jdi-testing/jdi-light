package io.github.com.custom.cards;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.complex.Card;

public class CustomActionsCard extends Card {

    @UI(".v-image__image")
    protected Image image;

    @UI("//./div[5]/div")
    protected Text dropdownText;

    public Image image() {
        return image;
    }

    public Button exploreButton() {
        return new Button().setCore(Button.class, actions().find("//button[./span[contains(text(), 'Explore')]]"));
    }

    public Button expandButton() {
        return new Button().setCore(Button.class, actions().find("button.v-btn--icon"));
    }

    public Text dropdownText() {
        return dropdownText;
    }
}
