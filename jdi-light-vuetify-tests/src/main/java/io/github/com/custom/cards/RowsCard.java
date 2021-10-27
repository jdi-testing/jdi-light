package io.github.com.custom.cards;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.Card;

public class RowsCard extends Card {

    public Icon icon() {
        return new Icon().setCore(Icon.class, title().find(".v-icon"));
    }

    public Text header() {
        return new Text().setCore(Text.class, title().find("h2"));
    }

    public WebList container() {
        return finds(".row > *");
    }
}
