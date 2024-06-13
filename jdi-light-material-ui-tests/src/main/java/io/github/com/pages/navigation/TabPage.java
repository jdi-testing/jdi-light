package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Tabs;

public class TabPage extends WebPage {

    @UI("//h2[text()='Simple tabs']/following::div//div[@class='MuiTabs-root']")
    public static Tabs simpleTabs;

    // @todo #5347 Box control should be added as a Container https://v4.mui.com/api/container/
    //  test page also exists https://jdi-testing.github.io/jdi-light/material/box_layout
    @UI("//h2[text()='Simple tabs']/following::div/div[@role='tabpanel' and not(@hidden)]")
    public static UIElement simplePanels;

    @UI("//h2[text()='Scrollable tabs']/following::div//div[@class='MuiTabs-root']")
    public static Tabs scrollableTabs;

    @UI("//h2[text()='Prevent scroll buttons']/following::div//div[@class='MuiTabs-root']")
    public static Tabs preventScrollTabs;

    @UI("//h2[text()='Vertical tab']/following::div//div[contains(@class,'MuiTabs-root')]")
    public static Tabs verticalTabs;
}
