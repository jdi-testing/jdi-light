package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.common.Overlay;

public class OverlaysPage extends VuetifyPage {

    @UI("#AbsoluteOverlay .v-overlay")
    public static Overlay absoluteOverlay;

    @UI("#AbsoluteOverlay button")
    public static VuetifyButton absoluteOverlayButton;

    @UI("#OpacityOverlay .v-overlay")
    public static Overlay opacityOverlay;

    @UI("#OpacityOverlay button")
    public static VuetifyButton opacityOverlayButton;

    @UI("#ZIndexOverlay .v-overlay")
    public static Overlay zIndexOverlay;

    @UI("#ZIndexOverlay button")
    public static VuetifyButton zIndexOverlayButton;

    @UI("#AdvancedOverlay")
    public static UIElement advancedOverlayCard;

    @UI("#LoaderOverlay .v-overlay")
    public static Overlay loaderOverlay;

    @UI("#LoaderOverlay button")
    public static VuetifyButton loaderOverlayButton;

}
