package io.github.epam.bootstrap.tests.composite.section.listGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupActiveItems;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Dmitrii Pavlov on 25.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class ActiveItemsTests extends TestsInit {

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
    String listClass = "list-group-item";

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, text1}, {2, text2}, {3, text3}, {4, text4}, {5, text5}
        };
    }

    @DataProvider
    public Object[][] listClasses() {
        return new Object[][]{
                {1}, {2}, {3}, {4}, {5}
        };
    }

    @Test
    public void isValidationTests() {
        listGroupActiveItems.listGroup.is().size(5);
        listGroupActiveItems.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("list-group");
        listGroupActiveItems.listGroup.get(1).is()
                .hasClass(listClass + " active");
    }

    @Test(dataProvider = "listData")
    public void listGroupTextTests(int num, String text) {
        listGroupActiveItems.listGroup.get(num).is().text(text);
    }

    @Test (dataProvider = "listClasses")
    public void listGroupClassesIsValidationTests(int num) {
        listGroupActiveItems.listGroup.get(num).is()
                .displayed()
                .enabled()
                .core()
                .hasClass(listClass);
    }
}
