package io.github.epam.bootstrap.tests.composite.section.listGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupHorizontal;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class Horizontal extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String text1 = "Cras justo odio";
    String text2 = "Dapibus ac facilisis in";
    String text3 = "Morbi leo risus";

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, text1}, {2, text2}, {3, text3}
        };
    }

    @Test
    public void initTests() {
        listGroupHorizontal.listGroup.is().size(3);
    }

    @Test(dataProvider = "listData")
    public void listGroupTests(int num, String text) {
        listGroupHorizontal.listGroup.get(num).is()
                .text(text)
                .css("font-size", is("14px"));
    }

}
