package io.github.com.pages.sections;

import com.epam.jdi.angular.elements.common.NestedDropdownMenu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MenuSection extends Section {

    @UI("#basic_menu_button")
    public NestedDropdownMenu basicMenu;

    @UI("#menu_with_icons_button")
    public NestedDropdownMenu menuWithIcons;

    @UI("#nested_menu_button")
    public NestedDropdownMenu nestedMenu;

    @UI("#basic-menu-selected-option")
    public Text basicMenuSelectedOption;
}
