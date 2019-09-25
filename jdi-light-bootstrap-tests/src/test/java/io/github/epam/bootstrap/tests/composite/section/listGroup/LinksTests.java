package io.github.epam.bootstrap.tests.composite.section.listGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupActiveItems;
import static io.github.com.pages.BootstrapPage.listGroupLinks;
import static io.github.epam.states.States.shouldBeLoggedIn;

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

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {0, text1}, {1, text2}, {2, text3}, {3, text4}, {4, text5}
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
        listGroupLinks.listGroup.get(0).is()
                .hasClass(listClass + " active");
        listGroupLinks.listGroup.get(4).is().disabled();
    }

    @Test(dataProvider = "listData")
    public void listGroupTextTests(int num, String text) {
        listGroupLinks.listGroup.get(num).is().text(text);
    }

}
