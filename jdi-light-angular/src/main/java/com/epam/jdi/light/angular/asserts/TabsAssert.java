package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.TabGroup;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TabsAssert extends UIAssert<TabsAssert, TabGroup> {

    @JDIAction("Assert that '{name}' has tabs count")
    public TabsAssert assertTabsCount(int tabsCountForTest) {
        jdiAssert(element.getTabsCount(), Matchers.is(tabsCountForTest));
        return this;
    }

    @JDIAction("Assert that '{name}' has value")
    public TabsAssert assertTabPanelContent(String stringForTest) {
        jdiAssert(element.tabPanelContainsValue(stringForTest), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has values")
    public TabsAssert assertTabsTitles(List<String> condition) {
        jdiAssert(element.tabsTitlesContainValues(condition), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is highlighted when '{0}' tab number is provided")
    public TabsAssert assertTabIsHighlighted(int tabNumber) {
        jdiAssert(element.tabIsHighlighted(tabNumber), Matchers.is(true));
        return this;
    }

    /*TABS NAV BAR LINKS ASSERTS*/
    @JDIAction("Assert that '{name}' has values")
    public TabsAssert assertTabsLinksTitles(List<String> condition) {
        jdiAssert(element.tabsLinksTitlesContainValues(condition), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is highlighted when '{0}' tab number is provided")
    public TabsAssert assertTabWithLinkIsHighlighted(String tabTitle) {
        jdiAssert(element.tabWithLinkIsHighlighted(tabTitle), Matchers.is(true));
        return this;
    }

}
