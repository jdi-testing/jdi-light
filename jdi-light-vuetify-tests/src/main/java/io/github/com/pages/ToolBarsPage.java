package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;

import java.util.List;

public class ToolBarsPage extends VuetifyPage {

    @UI("#backgroundToolbar")
    public static ToolBar backgroundToolbar;

    @UI("#collapseToolbar")
    public static ToolBar collapseToolbar;

    @UI("#denseToolbar")
    public static ToolBar denseToolbar;

    @UI("#extendedToolbar")
    public static ToolBar extendedToolbar;

    @UI("#floatingWithSearchToolbar")
    public static ToolBar floatingWithSearchToolbar;

    @UI("#contextActionToolbar")
    public static ToolBar contextActionToolbar;

    @UI("#flexibleAndCardToolbar")
    public static ToolBar flexibleAndCardToolbar;

    @UI("div[role=listbox]")
    public static Menu optionsMenu;

    @UI("div[role=option]")
    public static List<UIElement> options;
}

