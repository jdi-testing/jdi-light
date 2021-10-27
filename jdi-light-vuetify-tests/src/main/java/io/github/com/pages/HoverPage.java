package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JDIHover;
import com.epam.jdi.light.vuetify.elements.complex.Hover;
import io.github.com.custom.cards.MusicHoverCard;

import java.util.List;

public class HoverPage extends VuetifyPage {
    @UI("#DisabledHover .v-card")
    public static Hover disabledHover;

    @UI("//*[@id = 'OpenAndCloseDelayHover']//div[contains(@class, 'v-card') and .//*[contains(text(), 'enter')]]")
    public static Hover openDelayHover;

    @UI("//*[@id = 'OpenAndCloseDelayHover']//div[contains(@class, 'v-card') and .//*[contains(text(), 'leave')]]")
    public static Hover closeDelayHover;

    // list hover
    @UI("#ListHover .v-card")
    public static List<MusicHoverCard> musicHoverCards;

    // transition hover
    @UI("#TransitionHover .v-card--reveal")
    @JDIHover("#TransitionHover")
    public static Hover priceHover;

    @UI("#TransitionHover button")
    public static Button cartButton;

    @UI("#TransitionHover h3")
    public static Text cookingHeader;
}
