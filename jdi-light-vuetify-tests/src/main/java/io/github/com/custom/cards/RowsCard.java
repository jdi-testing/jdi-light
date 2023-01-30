package io.github.com.custom.cards;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.Card;

public class RowsCard extends Card {

    public RowsCard() {
        super();
    }

    public RowsCard(UIElement element) {
        setCore(RowsCard.class, element.base());
    }

    public Icon titleIcon() {
        return new Icon().setCore(Icon.class, title().find(".v-icon"));
    }
}
