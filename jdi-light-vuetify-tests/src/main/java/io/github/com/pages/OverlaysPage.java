package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Overlay;

public class OverlaysPage extends VuetifyPage {

    @UI("#AbsoluteOverlay .v-overlay")
    public static Overlay absoluteOverlay;

    @UI("#AbsoluteOverlay button")
    public static UIElement absoluteOverlayButton;

    @UI("#OpacityOverlay .v-overlay")
    public static Overlay opacityOverlay;

    @UI("#OpacityOverlay button")
    public static Button opacityOverlayButton;

    @UI("#ZIndexOverlay .v-overlay")
    public static Overlay zIndexOverlay;

    @UI("#ZIndexOverlay button")
    public static Button zIndexOverlayButton;

}
