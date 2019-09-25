package io.github.epam.bootstrap.tests.composite.section.listGroup;

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
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 25.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class LinksTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String text1 = "Cras justo odio";
    String text2 = "Dapibus ac facilisis in";
    String text3 = "Morbi leo risus";
    String text4 = "Porta ac consectetur ac";
    String text5 = "Vestibulum at eros";
    String listClass = "list-group-item list-group-item-action";
    String pageTitle1 = "JDI · GitHub";
    String pageTitle2 = "JDI Testing tools · GitHub";
    String pageTitle3 = "Home Page";
    String pageTitle4 = "List group · Bootstrap";

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
        listGroupLinks.listGroup.is().size(5);
        listGroupLinks.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("list-group");
        listGroupLinks.listGroup.get(1).is()
                .hasClass(listClass + " active");
        listGroupLinks.listGroup.get(5).is()
                .hasClass(listClass + " disabled");
    }

    @Test(dataProvider = "listData")
    public void listGroupTextTests(int num, String text) {
        listGroupLinks.listGroup.get(num).is().text(text);
    }

    @Test (dataProvider = "clickValidate")
    public void linkClickableTests(int index, String pageTitle) {
        listGroupLinks.listGroup.get(index).click();
        newWindowTitleCheck(pageTitle);
    }

    public void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
