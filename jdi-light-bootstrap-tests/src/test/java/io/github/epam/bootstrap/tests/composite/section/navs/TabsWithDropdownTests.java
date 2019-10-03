package io.github.epam.bootstrap.tests.composite.section.navs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navsTabsWithDropdown;
import static io.github.epam.bootstrap.tests.composite.section.navs.ClickVerification.newWindowTitleCheck;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 30.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class TabsWithDropdownTests extends TestsInit {

    private String link1 = "Active";
    private String link2 = "Dropdown";
    private String link3 = "JDI - testing tool";
    private String link4 = "Disabled";
    private String linkDrop1 = "JDI home";
    private String linkDrop2 = "JDI Docs";
    private String linkDrop3 = "JDI - testing tool";
    private String linkDrop4 = "Bootstrap";
    private String pageTitle1 = "Home Page";
    private String pageTitle2 = "JDI · GitHub";
    private String pageTitle3 = "JDI Testing tools · GitHub";
    private String pageTitle4 = "Bootstrap · The most popular HTML, CSS, and JS library in the world.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        navsTabsWithDropdown.hover();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, link1}, {2, link2}, {3, link3}, {4, link4}
        };
    }

    @DataProvider
    public Object[][] listLinkDrop() {
        return new Object[][]{
                {0, linkDrop1}, {1, linkDrop2}, {2, linkDrop3}, {3, linkDrop4}
        };
    }

    @DataProvider
    public Object[][] listPageTitle() {
        return new Object[][]{
                {pageTitle1, linkDrop1}, {pageTitle2, linkDrop2}, {pageTitle3, linkDrop3}, {pageTitle4, linkDrop4}
        };
    }

    @Test
    public void isValidationTests() {
        navsTabsWithDropdown.navItem.is()
                .size(4);
        navsTabsWithDropdown.navItemLink.is()
                .size(4);
        navsTabsWithDropdown.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("nav nav-tabs");
        navsTabsWithDropdown.navItemLink.get(1)
                .is()
                .core()
                .hasClass("active");
        navsTabsWithDropdown.navItemLink.get(4)
                .is()
                .core()
                .hasClass("disabled");
    }

    @Test
    public void dropdownIsValidationTests() {
        navsTabsWithDropdown.dropdownMenu.expand();
        navsTabsWithDropdown.dropdownMenu
                .is()
                .displayed()
                .expanded()
                .enabled();
        navsTabsWithDropdown.dropdownMenu
                .is()
                .expanded()
                .size(4)
                .core()
                .attr("data-toggle", "dropdown")
                .attr("aria-haspopup", "true")
                .attr("aria-expanded", "true")
                .attr("role", "button")
                .tag("a");
        navsTabsWithDropdown.dropdownMenu.expand();
    }

    @Test(dataProvider = "listLinkDrop")
    public void dropdownMenuTests(int index, String linkText) {
        navsTabsWithDropdown.dropdownMenu.expand();
        navsTabsWithDropdown.dropdownMenu.list().get(index)
                .is()
                .text(linkText);
    }

    @Test(dataProvider = "listData")
    public void itemsIsValidationTests(int index, String linkText) {
        navsTabsWithDropdown.navItem.get(index)
                .is()
                .core()
                .hasClass("nav-item")
                .text(is(containsString(linkText)));
        navsTabsWithDropdown.navItemLink.get(index)
                .is()
                .core()
                .hasClass("nav-link")
                .text(is(linkText));
    }

    @Test(dataProvider = "listPageTitle")
    public void dropdownClickableLiTests(String pageTitle, String link) {
        navsTabsWithDropdown.dropdownMenu.select(link);
        newWindowTitleCheck(pageTitle);
    }

    @Test
    public void linkClickableTests() {
        navsTabsWithDropdown.navItem.get(1).click();
        newWindowTitleCheck(pageTitle1);
        navsTabsWithDropdown.navItem.get(3).click();
        newWindowTitleCheck(pageTitle3);
    }
}
