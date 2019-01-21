package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import org.openqa.selenium.WebElement;

public class HtmlSelector extends Selector<HtmlElement> implements Dropdown, MultiSelect {
    public HtmlSelector() { }
    public HtmlSelector(WebElement el) { super(el); }

}
