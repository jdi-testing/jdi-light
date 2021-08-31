package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class TabPage extends WebPage {
    @UI("//button[contains(@aria-controls,'simple-tabpanel')]")
    public static List<Tabs> simpleTabs;

    @UI("//div[starts-with(@id,'simple-tabpanel')]")
    public static List<Text> simpleTabsContent;

    @UI("//button[contains(@aria-controls,'scrollable-auto-tab')]")
    public static List<Tabs> scrollableTabs;

    @UI("//div[starts-with(@id,'scrollable-auto-tabpanel')]")
    public static List<Text> scrollableTabsContent;

    @UI("//div[@class='MuiTabs-root']//div[contains(@class, 'MuiTabs-scrollButtonsDesktop')]")
    public static List<Button> buttonHorizontal;

    @UI("//button[contains(@aria-controls,'scrollable-prevent-tab')]")
    public static List<Tabs> preventScrollTabs;

    @UI("//div[starts-with(@id,'scrollable-prevent-tabpanel')]")
    public static List<Text> preventScrollTabsContent;

    @UI("//button[contains(@aria-controls,'vertical-tabpanel')]")
    public static List<Tabs> verticalTabs;

    @UI("//div[starts-with(@id,'vertical-tabpanel')]")
    public static List<Text> verticalTabsContent;

    @UI("//div[contains(@class, 'MuiTabScrollButton-vertical')]")
    public static List<Button> buttonVertical;
}
