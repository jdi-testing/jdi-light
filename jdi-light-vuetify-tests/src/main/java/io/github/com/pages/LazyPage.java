package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Card;


public class LazyPage extends VuetifyPage {

    @UI("#lazyCard .v-lazy")
    public static UIElement lazyContent;

    @UI("#lazyCard .v-card")
    public static Card lazyCard;
}
