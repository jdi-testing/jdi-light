package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.material.elements.displaydata.Lists;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class ListPage extends WebPage {
    @UI("//*[contains(text(),'sticky 0')]")
    public Lists stickyZero;

    @UI("//*[contains(text(),'sticky 1')]")
    public Lists stickyOne;

    @UI("//*[contains(text(),'List item 1')]")
    public Lists firstListItem;

    @UI("//*[contains(text(),'List item 2')]")
    public Lists secondListItem;

    @UI("//*[contains(text(),'Line item 1')]")
    public Lists lineItemFirst;

    @XPath("//*[contains(text(),'Line item 1')]/../../div[contains(@class, 'MuiListItemIcon-root')]/span")
    public Lists checkboxLineItemFirst;

    @UI("//*[contains(text(), 'Inbox')]")
    public Lists inputSelectedListItem;

    @UI("//*[contains(text(), 'Trash')]")
    public Lists trashSelectedListItem;

    @UI("//p[text()='Secondary text']")
    public List<Text> secondaryLineListItems;

    @UI("(//span[contains(@class,'MuiCheckbox-root')])")
    public List<Checkbox> enableSecondaryTextCheckbox;

    @UI("//h2[contains(text(),'List with Switch')]/following-sibling::ul[1]/li")
    public List<Checkbox> switchList;
}
