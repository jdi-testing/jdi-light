package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.TabsAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import java.util.List;

public class Tabs extends UIBaseElement<TabsAssert> implements IsText {

    /*TABS */
    private WebList getTabs() {
        return this.finds("[role='tab']");
    }

    private UIElement getTabByNumber(int tabNumber) {
        return getTabs().get(tabNumber);
    }

    private UIElement getTabByText(String text) {
        return getTabs().get(text);
    }

    private List<String> getTabsTitlesValues() {
        return getTabs().values();
    }

    public int getTabsCount() {
        return getTabs().size();
    }

    public void clickTab(int tabNumber) {
        getTabByNumber(tabNumber).click();
    }

    public void clickTab(String tabText) {
        getTabByText(tabText).click();
    }

    public Boolean tabsTitlesContainValues(List<String> listForTest) {
        return getTabsTitlesValues().containsAll(listForTest);
    }

    public Boolean tabIsHighlighted(int tabNumber) {
        return getTabByNumber(tabNumber).attr("aria-selected").equals("true");
    }

    /*TABS PANEL CONTENT*/
    private WebList getTabPanelContent() {
        return this.finds("[role='tabpanel']");
    }

    private List<String> getTabPanelContentValues() {
        return getTabPanelContent().values();
    }

    public Boolean tabPanelContainsValue(String valueForTest) {
        return getTabPanelContentValues().contains(valueForTest);
    }

    /*TABS NAV BAR LINKS*/
    public void clickTabLink(String tabText) {
        getTabLinkByTitle(tabText).click();
    }

    private WebList getTabsLinks() {
        return this.finds("a");
    }

    private UIElement getTabLinkByTitle(String linkText) {
        return getTabsLinks().get(linkText);
    }

    public int getTabLinksCount() {
        return getTabsLinks().size();
    }

    private List<String> getTabsLinksTitlesValues() {
        return getTabsLinks().values();
    }

    public Boolean tabsLinksTitlesContainValues(List<String> listForTest) {
        return getTabsLinksTitlesValues().containsAll(listForTest);
    }

    public Boolean tabWithLinkIsHighlighted(String tabName) {
        return getTabLinkByTitle(tabName).get().getAttribute("class").contains("active");
    }

    /*UTILS */
    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }

}


