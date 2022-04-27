package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Lazy;


public class LazyPage extends VuetifyPage {

    @UI(".v-lazy")
    public static Lazy lazy;

    @UI("div.mx-auto.v-card.v-sheet.theme--light")
    public static Lazy lazyContent;

    public static final String ITEM_TITLE = ".v-card__title";

    public static final String ITEM_TEXT = ".v-card__text";
}
