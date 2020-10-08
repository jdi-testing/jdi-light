package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.NestedDropdownMenu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MenuSection {

    @UI("#basic-menu-button")
    public static NestedDropdownMenu basicMenuButton;

    @UI("#menu-with-icons-button")
    public static NestedDropdownMenu menuWithIconsButton;

    @UI("#nested-menu-button")
    public static NestedDropdownMenu nestedMenuButton;

    @UI("#toolbar-basic")
    public static Text basicMenuSelectedOption;

    @UI("#nested-menu-selected-option")
    public static Text iconsMenuSelectedOption;

    @UI("#nested-menu-selected-option")
    public static Text nestedMenuSelectedOption;
}
