package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.WithText;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Menu;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;

public class MenusPage extends VuetifyPage {

    @UI("#AbsoluteMenu div.portrait")
    public static Image absoluteMenu;

    @UI("#AbsoluteWithoutActivatorMenu")
    public static Image absoluteWithoutActivatorMenu;

    @UI("#CloseOnClickMenu .v-input--switch")
    public static Switch closeOnClickMenuSwitch;

    @UI("#CloseOnClickMenu button")
    public static Button closeOnClickMenuButton;

    @UI("#OffsetXMenu .v-input--switch")
    public static Switch offsetXMenuSwitch;

    @UI("#OffsetXMenu button")
    public static Button offsetXMenuButton;

    @UI("#OffsetYMenu .v-input--switch")
    public static Switch offsetYMenuSwitch;

    @UI("#OffsetYMenu button")
    public static Button offsetYMenuButton;

    @UI("#OpenOnHoverMenu button")
    public static Button openOnHoverMenuButton;

    @WithText("Removed Radius")
    public static Button removedRadiusButton;

    @WithText("Large Radius")
    public static Button largeRadiusButton;

    @WithText("Custom Radius")
    public static Button customRadiusButton;

    @WithText("Dropdown w/ Tooltip")
    public static Button dropdownWithTooltipButton;

    @WithText("Scale Transition")
    public static Button scaleTransitionButton;

    @WithText("Slide X Transition")
    public static Button slideXTransitionButton;

    @WithText("Slide Y Transition")
    public static Button slideYTransitionButton;

    @WithText("Menu as Popover")
    public static Button menuAsPopoverButton;

    @UI("#UseInComponentsMenu")
    public static AppBar complexComponent;

    @UI("div.menuable__content__active")
    public static Menu activeMenu;

}
