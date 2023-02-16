package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.ProgressCircular;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.common.Overlay;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import io.github.com.custom.OverlayWithCloseButton;

public class OverlaysPage extends VuetifyPage {

    @UI("#AbsoluteOverlay .v-overlay")
    public static OverlayWithCloseButton absoluteOverlay;

    @UI("#AbsoluteOverlay button")
    public static VuetifyButton absoluteOverlayButton;

    @UI("#OpacityOverlay .v-overlay")
    public static OverlayWithCloseButton opacityOverlay;

    @UI("#OpacityOverlay button")
    public static VuetifyButton opacityOverlayButton;

    @UI("#ZIndexOverlay .v-overlay")
    public static OverlayWithCloseButton zIndexOverlay;

    @UI("#ZIndexOverlay button")
    public static VuetifyButton zIndexOverlayButton;

    @UI("#AdvancedOverlay")
    public static Card advancedOverlayCard;

    @UI("#AdvancedOverlay .v-overlay")
    public static Overlay advancedOverlay;

    @UI("#LoaderOverlay .v-overlay")
    public static Overlay loaderOverlay;

    @UI("#LoaderOverlay button")
    public static VuetifyButton loaderOverlayButton;

    @UI(".v-overlay--active .v-progress-circular")
    public static ProgressCircular progressCircular;
}
