package io.github.epam.bootstrap.tests.composite.section.navs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navsAlignmentCenter;
import static io.github.com.pages.BootstrapPage.navsAlignmentEnd;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 30.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class AlignmentTests extends TestsInit {

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
        navsAlignmentCenter.hover();
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
        navsAlignmentCenter.navItem.is()
                .size(4);
        navsAlignmentCenter.navItemLink.is()
                .size(4);
        navsAlignmentEnd.navItem.is()
                .size(4);
        navsAlignmentEnd.navItemLink.is()
                .size(4);
        navsAlignmentCenter.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("nav justify-content-center");
        navsAlignmentCenter.navItemLink.get(1)
                .is()
                .core()
                .hasClass("active");
        navsAlignmentCenter.navItemLink.get(4)
                .is()
                .core()
                .hasClass("disabled");
        navsAlignmentEnd.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("nav justify-content-end");
        navsAlignmentEnd.navItemLink.get(1)
                .is()
                .core()
                .hasClass("active");
        navsAlignmentEnd.navItemLink.get(4)
                .is()
                .core()
                .hasClass("disabled");
    }

    @Test(dataProvider = "listData")
    public void itemsIsValidationTests(int index, String linkText) {
        navsAlignmentCenter.navItem.get(index)
                .is()
                .core()
                .hasClass("nav-item")
                .text(is(linkText));
        navsAlignmentCenter.navItemLink.get(index)
                .is()
                .core()
                .hasClass("nav-link")
                .text(is(linkText));
        navsAlignmentEnd.navItem.get(index)
                .is()
                .core()
                .hasClass("nav-item")
                .text(is(linkText));
        navsAlignmentEnd.navItemLink.get(index)
                .is()
                .core()
                .hasClass("nav-link")
                .text(is(linkText));
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableLiTests(int index, String pageTitle) {
        navsAlignmentCenter.navItem.get(index).highlight();
        navsAlignmentCenter.navItem.get(index).click();
        newWindowTitleCheck(pageTitle);
        navsAlignmentCenter.navItem.get(index).unhighlight();
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableATests(int index, String pageTitle) {
        navsAlignmentEnd.navItemLink.get(index).highlight();
        navsAlignmentEnd.navItemLink.get(index).click();
        newWindowTitleCheck(pageTitle);
        navsAlignmentEnd.navItemLink.get(index).unhighlight();
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
