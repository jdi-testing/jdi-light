package io.github.com.pages.sections;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.Menu2D;

public class MenuSection extends Section {

    //@UI("//button//*[text()='Menu']")
    @UI("#basic_menu")
    public Menu basicMenu;

    @UI("#mat-menu-panel-0")
    public Menu2D matMenuPanel0;

    @UI("#menu_with_icons")
    public Menu menuWithIcons;

    @UI("#mat-menu-panel-1")
    public Menu matMenuPanel1;

    @UI("#nested_menu")
    public Menu nestedMenu;

    @UI("#basic-menu-selected-option")
    public Text basicMenuSelectedOption;
}
