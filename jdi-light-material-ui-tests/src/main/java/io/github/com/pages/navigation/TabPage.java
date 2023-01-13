package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Container;
import com.epam.jdi.light.material.elements.navigation.Tabs;

public class TabPage extends WebPage {

    @UI("h2+div[1] .MuiTabs-root")
    public static Tabs simpleTabs;

    @UI("//div[./h2[text()='Simple tabs']]/div[1]/div[@role='tabpanel' and not(@hidden)]")
    public static Container simplePanels;

    @UI("h2+div[2] .MuiTabs-root")
    public static Tabs scrollableTabs;

    @UI("h2+div[3] .MuiTabs-root")
    public static Tabs preventScrollTabs;

    @UI("h2+div[4] .MuiTabs-root")
    public static Tabs verticalTabs;
}
