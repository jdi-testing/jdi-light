package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Menu;

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

    @UI("div.menuable__content__active")
    public static Menu activeMenu;

}
