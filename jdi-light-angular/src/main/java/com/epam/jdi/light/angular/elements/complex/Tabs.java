package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.TabsAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import java.util.List;

public class Tabs extends UIBaseElement<TabsAssert> implements IsText {

    public void clickTab(int tabNumber) {
        getTabByNumber(tabNumber).click();
    }

    public void clickTab(String tabText) {
        getTabByText(tabText).click();
    }

    /*TABS */
    public WebList getTabs() {
        return this.finds("[role='tab']");
    }

    public UIElement getTabByNumber(int tabNumber) {
        return getTabs().get(tabNumber);
    }

    public UIElement getTabByText(String text) {
        return getTabs().get(text);
    }

    public int getTabsCount() {
        return getTabs().size();
    }

    public List<String> getTabsTitlesValues() {
        return getTabs().values();
    }

    /*boolean*/
    public Boolean tabsTitlesContainValues(List<String> listForTest) {
        return getTabsTitlesValues().containsAll(listForTest);
    }

    public Boolean tabIsHighlighted(int tabNumber) {
        return getTabByNumber(tabNumber).attr("aria-selected").equals("true");
    }

    /*TABS PANEL CONTENT*/
    public WebList getTabPanelContent() {
        return this.finds("[role='tabpanel']");
    }

    public List<String> getTabPanelContentValues() {
        return getTabPanelContent().values();
    }

    /*boolean*/
    public Boolean tabPanelContainsValue(String valueForTest) {
        return getTabPanelContentValues().contains(valueForTest);
    }

    /*TABS NAV BAR LINKS*/

    public void clickTabLink(String tabText) {
        getTabLinkByTitle(tabText).click();
    }

    public WebList getTabsLinks() {
        return this.finds("a");
    }

    public UIElement getTabLinkByTitle(String linkText) {
        return getTabsLinks().get(linkText);
    }

    public int getTabLinksCount() {
        return getTabsLinks().size();
    }

    public List<String> getTabsLinksTitlesValues() {
        return getTabsLinks().values();
    }

    /*boolean*/
    public Boolean tabsLinksTitlesContainValues(List<String> listForTest) {
        return getTabsLinksTitlesValues().containsAll(listForTest);
    }

    public Boolean tabWithLinkIsHighlighted(String tabName) {
        return getTabLinkByTitle(tabName).attr("ng-reflect-active").equals("true");
    }

    /*UTILS */
    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }
}


