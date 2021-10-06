package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Windows;
import io.github.com.custom.windows.SlideWindow;

public class WindowsPage extends VuetifyPage {

    @UI("#ReverseWindow .v-window")
    public static Windows<SlideWindow> reverseWindows;

    @UI("#ReverseWindow .v-card__actions > button:first-of-type")
    public static Button reverseBack;

    @UI("#ReverseWindow .v-item-group button")
    public static WebList reverseNavigation;

    @UI("#ReverseWindow .v-card__actions > button:last-of-type")
    public static Button reverseNext;

    @UI("#VerticalWindow .v-window")
    public static Windows<SlideWindow> verticalWindows;

    @UI("#VerticalWindow .v-card__actions > button:first-of-type")
    public static Button verticalBack;

    @UI("#VerticalWindow .v-item-group button")
    public static WebList verticalNavigation;

    @UI("#VerticalWindow .v-card__actions > button:last-of-type")
    public static Button verticalNext;

    @UI("#CustomizedArrowsWindow.v-window")
    public static Windows<SlideWindow> customizedArrowsWindows;

    @UI("#CustomizedArrowsWindow .v-window__prev button")
    public static Button previousSlide;

    @UI("#CustomizedArrowsWindow .v-window__next button")
    public static Button nextSlide;

    @UI("#AccountCreationWindow .v-window")
    public static Windows<?> accountCreationWindows;

    @UI("#AccountCreationWindow .v-card__actions > button:first-of-type")
    public static Button accountBack;

    @UI("#AccountCreationWindow .v-card__actions > button:last-of-type")
    public static Button accountNext;

    @UI("#OnboardingWindow .v-window")
    public static Windows<Section> onboardingWindows;

    @UI("#OnboardingWindow .v-item-group button")
    public static WebList onboardingNavigation;

}
