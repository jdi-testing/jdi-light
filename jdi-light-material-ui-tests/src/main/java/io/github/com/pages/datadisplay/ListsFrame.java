package io.github.com.pages.datadisplay;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.material.elements.datadisplay.Lists;

public class ListsFrame extends UIElement {
    @UI("//*[contains(text(),'List item 1')]")
    public Lists firstListItem;

    @UI("//*[contains(text(),'List item 2')]")
    public Lists secondListItem;

    @UI("//*[contains(text(),'Line item 1')]")
    public Lists lineItemFirst;

    @XPath("//*[contains(text(),'Line item 1')]/../../div[contains(@class, 'MuiListItemIcon-root')]/span")
    public Lists checkboxLineItemFirst;

    @UI("//*[contains(text(),'sticky 0')]")
    public Lists stickyZero;

    @UI("//*[contains(text(),'sticky 1')]")
    public Lists stickyOne;
}
