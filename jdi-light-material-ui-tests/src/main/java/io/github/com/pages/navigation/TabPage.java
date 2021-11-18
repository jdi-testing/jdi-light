package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Tabs;


import java.util.List;

public class TabPage extends WebPage {
    @UI("//button[contains(@aria-controls,'simple-tabpanel')]")
    public static List<Tabs> simpleTabs;

    @UI("//button[contains(@aria-controls,'scrollable-auto-tab')]")
    public static List<Tabs> scrollableTabs;

    @UI("//button[contains(@aria-controls,'scrollable-prevent-tab')]")
    public static List<Tabs> preventScrollTabs;

    @UI("//button[contains(@aria-controls,'vertical-tabpanel')]")
    public static List<Tabs> verticalTabs;
}
