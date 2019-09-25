package io.github.epam.bootstrap.tests.composite.section.listGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.listGroupWithBadges;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class WithBadgesTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void initTests() {
        listGroupWithBadges.listGroup.is().size(5);
    }

    @Test(dataProvider = "listData")
    public void listGroupTests(int num, String text) {
        listGroupWithBadges.listGroup.get(num).is()
                .text(text)
                .css("font-size", is("14px"));
    }

}
