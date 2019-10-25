package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

public class Dropdown extends UIBaseElement<UIAssert> implements IsButton{
    @Css(".dropdown-toggle") public Button dropdownToggle;
    @Css(".dropdown-menu") public UIElement dropdownMenu;
    @Css(".dropdown-menu > *") public WebList items;

}
