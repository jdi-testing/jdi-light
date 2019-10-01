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
import static io.github.com.pages.BootstrapPage.navsVerticalA;
import static io.github.com.pages.BootstrapPage.navsVerticalLi;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 30.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class VerticalTests extends TestsInit {

    private static final String JS_SCROLL_TO_ELEMENT = "arguments[0].scrollIntoView(true);";
    private static final String HEADER_RIGHT_PART = "#nav-vert-li";
    private String link1 = "Active";
    private String link2 = "JDI Docs";
    private String link3 = "JDI - testing tool";
    private String link4 = "Disabled";
    private String pageTitle1 = "Home Page";
    private String pageTitle2 = "JDI · GitHub";
    private String pageTitle3 = "JDI Testing tools · GitHub";

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

    @DataProvider
    public Object[][] clickValidate() {
        return new Object[][]{
                {1, pageTitle1}, {2, pageTitle2}, {3, pageTitle3}
        };
    }

    @Test
    public void isValidationTests() {
        navsVerticalLi.navItem.is()
                .size(4);
        navsVerticalA.navItemLink.is()
                .size(4);
        navsVerticalLi.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("nav flex-column");
        navsVerticalA.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("nav flex-column");
        navsVerticalLi.navItemLink.get(1)
                .is()
                .core()
                .hasClass("active");
        navsVerticalLi.navItemLink.get(4)
                .is()
                .core()
                .hasClass("disabled");
    }

    @Test(dataProvider = "listData")
    public void itemsIsValidationTests(int index, String linkText) {
        navsVerticalLi.navItem.get(index).is()
                .core()
                .hasClass("nav-item")
                .text(is(linkText));
        navsVerticalLi.navItemLink.get(index).is()
                .core()
                .hasClass("nav-link")
                .text(is(linkText));
        navsVerticalA.navItemLink.get(index).is()
                .core()
                .hasClass("nav-link")
                .text(is(linkText));
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableLiTests(int index, String pageTitle) {
        navsVerticalLi.navItem.get(index).highlight();
        navsVerticalLi.navItem.get(index).click();
        newWindowTitleCheck(pageTitle);
        navsVerticalLi.navItem.get(index).unhighlight();
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableATests(int index, String pageTitle) {
        navsVerticalA.navItemLink.get(index).highlight();
        navsVerticalA.navItemLink.get(index).click();
        newWindowTitleCheck(pageTitle);
        navsVerticalA.navItemLink.get(index).unhighlight();
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
