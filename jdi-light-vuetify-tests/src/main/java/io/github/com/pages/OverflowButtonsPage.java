package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;

public class OverflowButtonsPage extends VuetifyPage {


    @UI("#CounterOverflowButton .v-overflow-btn")
    public static OverflowButton counterOverflowButton;

    @UI("#DenseOverflowButton .v-overflow-btn")
    public static OverflowButton denseOverflowButton;

    @UI("#HintOverflowButton .v-overflow-btn")
    public static OverflowButton hintOverflowButton;

}
