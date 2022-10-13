package io.github.com.custom.cards;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Text;

public class ButtonCard extends Card {

    public Text text() {
        return new Text().setCore(Text.class, content().find("p"));
    }

    public Button button() {
        return new Button().setCore(Button.class, find("button"));
    }
}
