package io.github.com.custom.cards;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Text;

public class OutlinedCard extends Card {

    @UI(".text-overline")
    protected Text overlineText;

    @UI(".v-avatar")
    protected Avatar avatar;

    public OutlinedCard() {
        super();
    }

    public OutlinedCard(UIElement element) {
        setCore(OutlinedCard.class, element.base());
    }

    @Override
    public Text title() {
        return new Text().setCore(Text.class, core().find(".v-list-item__title"));
    }

    @Override
    public UIElement subtitle() {
        return core().find(".v-list-item__subtitle");
    }

    public Text overlineText() {
        return overlineText;
    }

    public Button button() {
        return new Button().setCore(Button.class, actions().find("button"));
    }

    public Avatar avatar() {
        return avatar;
    }
}
