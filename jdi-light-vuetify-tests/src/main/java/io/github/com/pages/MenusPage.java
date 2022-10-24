package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.WithText;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.Tooltip;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
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
    public static VuetifyButton closeOnClickMenuButton;

    @UI("#OffsetXMenu .v-input--switch")
    public static Switch offsetXMenuSwitch;

    @UI("#OffsetXMenu button")
    public static VuetifyButton offsetXMenuButton;

    @UI("#OffsetYMenu .v-input--switch")
    public static Switch offsetYMenuSwitch;

    @UI("#OffsetYMenu button")
    public static VuetifyButton offsetYMenuButton;

    @UI("#OpenOnHoverMenu button")
    public static VuetifyButton openOnHoverMenuButton;

    @WithText("Removed Radius")
    public static VuetifyButton removedRadiusButton;

    @WithText("Large Radius")
    public static VuetifyButton largeRadiusButton;

    @WithText("Custom Radius")
    public static VuetifyButton customRadiusButton;

    @WithText("Dropdown w/ Tooltip")
    public static VuetifyButton dropdownWithTooltipButton;

    @UI("div.v-tooltip__content")
    public static Tooltip tooltip;

    @WithText("Scale Transition")
    public static VuetifyButton scaleTransitionButton;

    @WithText("Slide X Transition")
    public static VuetifyButton slideXTransitionButton;

    @WithText("Slide Y Transition")
    public static VuetifyButton slideYTransitionButton;

    @WithText("Menu as Popover")
    public static VuetifyButton menuAsPopoverButton;

    @UI("#UseInComponentsMenu")
    public static AppBar complexComponent;

    @UI("div.menuable__content__active")
    public static Menu activeMenu;

}
