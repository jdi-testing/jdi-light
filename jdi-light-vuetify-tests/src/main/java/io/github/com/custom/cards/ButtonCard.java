package io.github.com.custom.cards;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Text;

public class ButtonCard extends Card {

    public ButtonCard() {
        super();
    }

    public ButtonCard(UIElement element) {
        setCore(ButtonCard.class, element.base());
    }

    public Text text() {
        return new Text().setCore(Text.class, content().find("p"));
    }

    public Button button() {
        return new Button().setCore(Button.class, core().find("button"));
    }
}
