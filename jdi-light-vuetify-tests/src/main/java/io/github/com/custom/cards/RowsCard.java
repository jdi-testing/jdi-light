package io.github.com.custom.cards;

import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.Card;

public class RowsCard extends Card {

    public Icon titleIcon() {
        return new Icon().setCore(Icon.class, title().find(".v-icon"));
    }
}
