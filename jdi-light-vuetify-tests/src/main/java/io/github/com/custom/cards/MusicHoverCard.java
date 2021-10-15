package io.github.com.custom.cards;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Hover;

import java.util.List;

public class MusicHoverCard extends Card {
    @UI(".v-image")
    private Hover hover;

    @UI("button")
    private List<Button> playerButtons;

    @UI(".subheading")
    private Text subheading;

    public Hover getHover() {
        return hover;
    }

    public List<Button> getPlayerButtons() {
        return playerButtons;
    }

    public Text getSubheading() {
        return subheading;
    }
}
