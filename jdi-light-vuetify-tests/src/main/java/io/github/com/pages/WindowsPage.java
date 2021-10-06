package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Windows;
import io.github.com.custom.windows.SlideWindow;

public class WindowsPage extends VuetifyPage {

    @UI("#ReverseWindow .v-window")
    public static Windows<SlideWindow> reverseWindows;

    @UI("#ReverseWindow button[5]")
    public static Button next;

    @UI("#VerticalWindow .v-window")
    public static Windows<SlideWindow> verticalWindows;

    @UI("#CustomizedArrowsWindow.v-window")
    public static Windows<SlideWindow> customizedArrowsWindows;

    @UI("#AccountCreationWindow .v-window")
    public static Windows<?> accountCreationWindows;

    @UI("#AccountCreationWindow button[2]")
    public static Button next2;

    @UI("#OnboardingWindow .v-window")
    public static Windows<SlideWindow> onboardingWindows;

}
