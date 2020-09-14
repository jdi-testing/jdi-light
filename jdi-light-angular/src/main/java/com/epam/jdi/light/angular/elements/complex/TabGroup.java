package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.TabGroupAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import java.util.List;

/**
 * To see an example of TabGroup web element please visit https://material.angular.io/components/tabs/overview.
 */

public class TabGroup extends UIBaseElement<TabGroupAssert> implements IsText {

    @JDIAction("Get '{name}' tabs count")
    public int getTabsCount() {
        return getTabs().size();
    }

    @JDIAction("Click '{name}' tab by tab number '{0}'")
    public void clickTab(int tabNumber) {
        getTabByNumber(tabNumber).click();
    }

    @JDIAction("Click '{name}' tab by text '{0}'")
    public void clickTab(String tabText) {
        getTabByText(tabText).click();
    }

    @JDIAction("Check '{name}' tabs titles contain values '{0}'")
    public Boolean tabsTitlesContainValues(List<String> listForTest) {
        return getTabsTitlesValues().containsAll(listForTest);
    }

    @JDIAction("Check '{name}' tab number '{0}' is highlighted")
    public Boolean tabIsHighlighted(int tabNumber) {
        return getTabByNumber(tabNumber).attr("aria-selected").equals("true");
    }

    @JDIAction("Check '{name}' panel content contain values '{0}'")
    public Boolean tabPanelContainsValue(String valueForTest) {
        return getTabPanelContentValues().contains(valueForTest);
    }

    @JDIAction("Click '{name}' tab-link by tab number '{0}'")
    public void clickTabLink(String tabText) {
        getTabLinkByTitle(tabText).click();
    }

    @JDIAction("Get '{name}' tab-link count")
    public int getTabLinksCount() {
        return getTabsLinks().size();
    }

    @JDIAction("Check '{name}' tab-links titles contain values '{0}'")
    public Boolean tabsLinksTitlesContainValues(List<String> listForTest) {
        return getTabsLinksTitlesValues().containsAll(listForTest);
    }

    @JDIAction("Check '{name}' tab-link number '{0}' is highlighted")
    public Boolean tabWithLinkIsHighlighted(String tabName) {
        return getTabLinkByTitle(tabName).get().getAttribute("class").contains("active");
    }

    @Override
    public TabGroupAssert is() {
        return new TabGroupAssert().set(this);
    }

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

    private WebList getTabPanelContent() {
        return this.finds("[role='tabpanel']");
    }

    private List<String> getTabPanelContentValues() {
        return getTabPanelContent().values();
    }

    private WebList getTabsLinks() {
        return this.finds("a");
    }

    private UIElement getTabLinkByTitle(String linkText) {
        return getTabsLinks().get(linkText);
    }

    private List<String> getTabsLinksTitlesValues() {
        return getTabsLinks().values();
    }
}


