package io.github.epam.bootstrap.tests.composite.section.navs;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navsTabs;
import static io.github.epam.bootstrap.tests.composite.section.navs.ClickVarification.testElementClick;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 30.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class TabsTests extends TestsInit {

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
        navsTabs.hover();
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
        navsTabs.navItem.is()
                .size(4);
        navsTabs.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("nav nav-tabs");
        navsTabs.navItemLink.get(1)
                .is()
                .core()
                .hasClass("active");
        navsTabs.navItemLink.get(4)
                .is()
                .core()
                .hasClass("disabled");
    }

    @Test(dataProvider = "listData")
    public void itemsIsValidationTests(int index, String linkText) {
        navsTabs.navItem.get(index)
                .is()
                .core()
                .hasClass("nav-item")
                .text(is(linkText));
        navsTabs.navItemLink.get(index)
                .is()
                .core()
                .hasClass("nav-link")
                .text(is(linkText));
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableLiTests(int index, String pageTitle) {
        UIElement element = navsTabs.navItem.get(index);
        testElementClick(element, pageTitle);
    }
}
