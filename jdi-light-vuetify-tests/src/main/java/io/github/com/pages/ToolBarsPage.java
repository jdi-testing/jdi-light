package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Select;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import io.github.com.custom.bars.ToolbarWithSearch;

public class ToolBarsPage extends VuetifyPage {

    @UI("#collapseToolbar .v-toolbar")
    public static ToolBar collapseToolbar;

    @UI("#extendedToolbar .v-toolbar")
    public static ToolBar extendedToolbar;

    @UI("#floatingWithSearchToolbar .v-toolbar")
    public static ToolbarWithSearch floatingWithSearchToolbar;

    @UI("#contextActionToolbar .v-toolbar")
    public static ToolBar contextActionToolbar;

    @JDropdown(root = "#contextActionToolbar .v-select",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]")
    public static Select contextActionToolbarSelect;

    @UI("#flexibleAndCardToolbar .v-toolbar")
    public static ToolBar flatToolbar;
}
