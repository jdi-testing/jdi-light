package io.github.com.custom.cards;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JDIHover;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Hover;

public class CookingHoverCard extends Card {

    @UI("#TransitionHover .v-card--reveal")
    @JDIHover("#TransitionHover")
    private Hover priceHover;

    @UI("#TransitionHover button")
    private Button cartButton;

    @UI("#TransitionHover h3")
    private Text cookingHeader;

    public Hover getPriceHover() {
        return priceHover;
    }

    public Button getCartButton() {
        return cartButton;
    }

    public Text getCookingHeader() {
        return cookingHeader;
    }
}