package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.window.Window;
import io.github.com.custom.windows.SlideWindow;

public class WindowsPage extends VuetifyPage {

    @UI("#ReverseWindow")
    public static SlideWindow reverseWindow;

    @UI("#VerticalWindow")
    public static SlideWindow verticalWindow;

    @UI("#CustomizedArrowsWindow")
    public static Window customizedArrowsWindow;

    @UI("#OnboardingWindow .v-window")
    public static SlideWindow onboardingWindow;
}
