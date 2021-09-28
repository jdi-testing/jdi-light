package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.composite.BottomNavigation;

public class BottomNavigationPage extends VuetifyPage {

    @UI("#colorBottomNavigation")
    public static BottomNavigation bottomNavigationColor;

    @UI("#growBottomNavigation")
    public static BottomNavigation bottomNavigationGrow;

    @UI("#hideOnScrollBottomNavigation .v-bottom-navigation")
    public static BottomNavigation bottomNavigationHideOnScroll;

    @UI("#horizontalBottomNavigation")
    public static BottomNavigation bottomNavigationHorizontal;

    @UI("#scrollThresholdBottomNavigation .v-bottom-navigation")
    public static BottomNavigation bottomNavigationScrollThreshold;

    @UI("#shiftBottomNavigation")
    public static BottomNavigation bottomNavigationShift;

    @UI("#toggleBottomNavigation .v-bottom-navigation")
    public static BottomNavigation bottomNavigationToggle;

    @UI("//span[normalize-space(text())='Toggle Navigation']/..")
    public static Button toggleNavigationButton;

    @UI("#hideOnScrollBottomNavigation")
    public static UIElement hideAndScrollPanel;

    @UI("#scrollThresholdBottomNavigation")
    public static UIElement scrollThresholdPanel;
}
