package io.github.epam.bootstrap.tests.composite.section.listgroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupLinks;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Created by Dmitrii Pavlov on 25.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class LinksTests extends TestsInit {

    private String text1 = "JDI Docs";
    private String text2 = "JDI - testing tool";
    private String text3 = "JDI website";
    private String text4 = "Bootstrap";
    private String text5 = "JDI Docs";
    private String listClass = "list-group-item list-group-item-action";
    private String pageTitle1 = "JDI · GitHub";
    private String pageTitle2 = "JDI Testing tools · GitHub";
    private String pageTitle3 = "Home Page";
    private String pageTitle4 = "List group · Bootstrap";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, text1}, {2, text2}, {3, text3}, {4, text4}, {5, text5}
        };
    }

    @DataProvider
    public Object[][] clickValidate() {
        return new Object[][]{
                {1, pageTitle1}, {2, pageTitle2}, {3, pageTitle3}, {4, pageTitle4}
        };
    }

    @Test
    public void isValidationTests() {
        listGroupLinks.listGroup.is()
                .size(5);
        listGroupLinks.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("list-group");
        listGroupLinks.listGroup.get(1).is()
                .hasClass(listClass + " active");
        listGroupLinks.listGroup.get(5).is()
                .hasClass(listClass + " disabled");
        assertFalse(listGroupLinks.listGroup.get(5).isClickable());
    }

    @Test(dataProvider = "listData")
    public void listGroupTextTests(int index, String text) {
        listGroupLinks.listGroup.get(index).is()
                .text(text).core()
                .css("font-size", is("14px"));
    }

    @Test(dataProvider = "clickValidate")
    public void linkClickableTests(int index, String pageTitle) {
        listGroupLinks.listGroup.get(index).highlight();
        listGroupLinks.listGroup.get(index).click();
        newWindowTitleCheck(pageTitle);
        listGroupLinks.listGroup.get(index).unhighlight();
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
