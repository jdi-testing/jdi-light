package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;

public class SystemBarsPage extends VuetifyPage {

    @UI("#system-bar-colored-primary")
    public static SystemBar systemBarColoredPrimary;

    @UI("#system-bar-colored-red")
    public static SystemBar systemBarColoredRed;

    @UI("#system-bar-colored-indigo")
    public static SystemBar systemBarColoredIndigo;

    @UI("#system-bar-lights-out-light")
    public static SystemBar systemBarLightsOutLight;

    @UI("#system-bar-lights-out-datk")
    public static SystemBar systemBarLightsOutDark;

    @UI("#system-bar-window")
    public static SystemBar systemBarWindow;

    @UI("#system-bar-absolute-position")
    public static SystemBar systemBarAbsolutePosition;

    @UI("#system-bar-app")
    public static SystemBar systemBarApp;

    @UI("#system-bar-high")
    public static SystemBar systemBarHigh;

}