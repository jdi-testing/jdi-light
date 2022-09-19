package io.github.com.custom.cards;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.CustomText;

public class ButtonCard extends Card {

    public CustomText text() {
        return new CustomText().setCore(CustomText.class, content().find("p"));
    }

    public Button button() {
        return new Button().setCore(Button.class, find("button"));
    }
}
