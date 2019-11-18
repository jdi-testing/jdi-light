package io.github.com.sections.dropdown;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.DropdownMenu;

public class DropdownMenuContent extends DropdownMenu {

    @UI(".dropdown-header")
    public Text header;

    @UI(".dropdown-divider")
    public UIElement divider;

    @UI("p")
    public JList<Text> text;

}
