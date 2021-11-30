package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Tabs;

public class TabPage extends WebPage {
    @UI("//button[contains(@aria-controls,'simple-tabpanel')]")
    public static Tabs simpleTabs;

    @UI("//button[contains(@aria-controls,'scrollable-auto-tab')]")
    public static Tabs scrollableTabs;

    @UI("//button[contains(@aria-controls,'scrollable-prevent-tab')]")
    public static Tabs preventScrollTabs;

    @UI("//button[contains(@aria-controls,'vertical-tabpanel')]")
    public static Tabs verticalTabs;
}
