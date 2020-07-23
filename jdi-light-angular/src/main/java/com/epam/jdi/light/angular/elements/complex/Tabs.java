package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.TabsAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import java.util.List;

public class Tabs extends UIBaseElement<TabsAssert> implements IsText {

    /*elements clicks*/
    public Tabs clickTab(int tabNumber) {
        getTabByNumber(tabNumber).click();
        return this;
    }

    public Tabs clickTab(String tabText) {
        getTabByText(tabText).click();
        return this;
    }

    /*links nav bar*/
    public Tabs clickTabLink(String tabText) {
        getTabLinkByTitle(tabText).click();
        return this;
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
        System.out.println(getTabs().values() + " TAB VALUES");
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
        System.out.println(getTabPanelContent().values() + "  CONTENT");
        return getTabPanelContent().values();
    }

    /*boolean*/
    public Boolean tabPanelContainsValue(String valueForTest) {
        return getTabPanelContentValues().contains(valueForTest);
    }

    /*TABS WITH NAV BAR LINKS*/
    public WebList getTabsLinks() {
        return this.finds("a");
    }

    public UIElement getTabLinkByTitle(String linkText) {
        return getTabsLinks().get(linkText);
    }

    public int getTabLinksCount() {
        return getTabsLinks().size();
    }

    public Boolean tabsLinksTitlesContainValues(List<String> listForTest) {
        return getTabsLinksTitlesValues().containsAll(listForTest);
    }

    public Boolean tabWithLinkIsHighlighted(String tabName) {
        return getTabLinkByTitle(tabName).attr("ng-reflect-active").equals("true");
    }

    public List<String> getTabsLinksTitlesValues() {
        System.out.println(getTabsLinks().values() + " TAB VALUES");
        return getTabsLinks().values();

    }

    /*UTILS */
    @Override
    public TabsAssert is() {
        return new TabsAssert().set(this);
    }
}

//    public  WebList verifyTabPanelContentText(){
//
//        WebList list =  getTabPanelContent();
//
//        return list;
//    }


//    private List<String> getValues() {
//        List<String> values = new ArrayList<>();
//        WebList options = getTabs();
//        options.forEach(option -> values.add(option.getValue()));
//        return values;
//    }


//    @JDIAction("Is '{name}' is expanded")
//    public Boolean expanded() {
//        if (getOptions().isEmpty()) {
//            return false;
//        } else {
//            return getOptions().get(1).
//                    getAllAttributes().keys().
//                    contains(getAutocompleteUniqueAttribute());
//        }
//    }

