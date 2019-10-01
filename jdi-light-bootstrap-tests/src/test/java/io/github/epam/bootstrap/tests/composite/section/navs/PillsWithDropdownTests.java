package io.github.epam.bootstrap.tests.composite.section.navs;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navsPillsWithDropdown;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 30.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PillsWithDropdownTests extends TestsInit {

    private static final String JS_SCROLL_TO_ELEMENT = "arguments[0].scrollIntoView(true);";
    private static final String HEADER_RIGHT_PART = "#nav-pills-drop";
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
        ((JavascriptExecutor) getDriver()).executeScript(JS_SCROLL_TO_ELEMENT, getDriver().findElement(By.cssSelector(HEADER_RIGHT_PART)));
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, link1}, {2, link2}, {3, link3}, {4, link4}
        };
    }

    @Test
    public void isValidationTests() {
        navsPillsWithDropdown.navItem.is()
                .size(4);
        navsPillsWithDropdown.navItemLink.is()
                .size(4);
        navsPillsWithDropdown.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("nav nav-pills");
        navsPillsWithDropdown.navItemLink.get(1)
                .is()
                .core()
                .hasClass("active");
        navsPillsWithDropdown.navItemLink.get(4)
                .is()
                .core()
                .hasClass("disabled");
    }

    @Test
    public void dropdownIsValidationTests() {
        navsPillsWithDropdown.dropdownMenu.expand();
        navsPillsWithDropdown.dropdownMenu
                .is()
                .displayed()
                .expanded()
                .enabled();
        navsPillsWithDropdown.dropdownMenu
                .is()
                .expanded()
                .size(4)
                .core()
                .attr("data-toggle", "dropdown")
                .attr("aria-haspopup", "true")
                .attr("aria-expanded", "true")
                .attr("role", "button")
                .tag("a");
        navsPillsWithDropdown.dropdownMenu.expand();
    }

    @Test
    public void dropdownMenuTests() {
        navsPillsWithDropdown.dropdownMenu.expand();
        navsPillsWithDropdown.dropdownMenu.list().get(0)
                .is()
                .text(linkDrop1);
        navsPillsWithDropdown.dropdownMenu.list().get(1)
                .is()
                .text(linkDrop2);
        navsPillsWithDropdown.dropdownMenu.list().get(2)
                .is()
                .text(linkDrop3);
        navsPillsWithDropdown.dropdownMenu.list().get(3)
                .is()
                .text(linkDrop4);
    }

    @Test(dataProvider = "listData")
    public void itemsIsValidationTests(int index, String linkText) {
        navsPillsWithDropdown.navItem.get(index)
                .is()
                .core()
                .hasClass("nav-item")
                .text(is(containsString(linkText)));
        navsPillsWithDropdown.navItemLink.get(index)
                .is()
                .core()
                .hasClass("nav-link")
                .text(is(linkText));
    }

    @Test
    public void dropdownClickableTests() {
        navsPillsWithDropdown.dropdownMenu.select(linkDrop1);
        newWindowTitleCheck(pageTitle1);
        navsPillsWithDropdown.dropdownMenu.select(linkDrop2);
        newWindowTitleCheck(pageTitle2);
        navsPillsWithDropdown.dropdownMenu.select(linkDrop3);
        newWindowTitleCheck(pageTitle3);
        navsPillsWithDropdown.dropdownMenu.select(linkDrop4);
        newWindowTitleCheck(pageTitle4);
    }

    @Test
    public void linkClickableTests() {
        navsPillsWithDropdown.navItem.get(1).click();
        newWindowTitleCheck(pageTitle1);
        navsPillsWithDropdown.navItem.get(3).click();
        newWindowTitleCheck(pageTitle3);
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}