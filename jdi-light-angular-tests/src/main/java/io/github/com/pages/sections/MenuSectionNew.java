package io.github.com.pages.sections;

import com.epam.jdi.angular.elements.common.NestedDropdownMenu;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.Menu2D;

public class MenuSectionNew {

    @UI("#basic_menu_button")
    public static NestedDropdownMenu basicMenu;

    @UI("#menu_with_icons_button")
    public static NestedDropdownMenu menuWithIcons;

    @UI("#nested_menu_button")
    public static NestedDropdownMenu nestedMenu;

    @UI("#basic-menu-selected-option")
    public static Text basicMenuSelectedOption;

    @UI("#icons-menu-selected-option")
    public static Text iconsMenuSelectedOption;

    @UI("#nested-menu-selected-option")
    public static Text nestedMenuSelectedOption;
}
