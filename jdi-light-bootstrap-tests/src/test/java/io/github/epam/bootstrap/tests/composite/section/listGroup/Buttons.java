package io.github.epam.bootstrap.tests.composite.section.listGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupButtons;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class Buttons extends TestsInit {

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
                {1, text1}, {2, text2}, {3, text3}, {4, text4}, {5, text5}
        };
    }

    @Test
    public void isValidationTests() {
        listGroupButtons.listGroup.is().size(5);
        listGroupButtons.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("list-group");
        listGroupButtons.listGroup.get(1).is()
                .hasClass(listClass + " active");
        listGroupButtons.listGroup.get(5).is().disabled();
    }

    @Test(dataProvider = "listData")
    public void listGroupTextTests(int num, String text) {
        listGroupButtons.listGroup.get(num).is().text(text);
    }

}
