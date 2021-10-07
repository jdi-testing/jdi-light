package io.github.com.custom.cards;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.complex.Card;

public class MediaTextCard extends Card {

    @UI(".v-image__image")
    protected Image image;

    public Image image() {
        return image;
    }

    public Button shareButton() {
        return new Button().setCore(Button.class, actions().find("//button[./span[contains(text(), 'Share')]]"));
    }

    public Button exploreButton() {
        return new Button().setCore(Button.class, actions().find("//button[./span[contains(text(), 'Explore')]]"));
    }

}
