package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Windows;
import io.github.com.custom.windows.AccountCreationWindows;
import io.github.com.custom.windows.SlideWindow;
import io.github.com.custom.windows.TitleWindow;

public class WindowsPage extends VuetifyPage {

    @UI("#ReverseWindow .v-window")
    public static Windows<SlideWindow> reverseWindows;
    @UI("#VerticalWindow .v-window")
    public static Windows<SlideWindow> verticalWindows;
    @UI("#CustomizedArrowsWindow.v-window")
    public static Windows<SlideWindow> customizedArrowsWindows;
    @UI("#AccountCreationWindow")
    public static AccountCreationWindows accountCreationWindows;
    @UI("#OnboardingWindow .v-window")
    public static Windows<Section> onboardingWindows;
    @UI("#VerticalButtonsWindow .v-window")
    public static Windows<TitleWindow> verticalButtonsWindows;
}
