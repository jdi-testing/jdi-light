package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.bottomNavigationPage;
import static io.github.com.pages.navigation.BottomNavigationPage.*;


/**
 * To see an example of Bottom Navigation web element please visit
 * https://material-ui.com/components/bottom-navigation/
 */

public class BottomNavigationTests extends TestsInit {

    @BeforeMethod
    public void before() {
        bottomNavigationPage.open();
        bottomNavigationPage.checkOpened();
    }

    @Test
    public void defaultBottomNavigationTest() {
        bottomNavigationItems.get(1).click();
        bottomNavigationItems.get(1).is().selected();
        bottomNavigationItems.get(2).is().notSelected();
        bottomNavigationItems.get(3).is().notSelected();

        jdiAssert(bottomNavigationItems.size(), Matchers.is(3));
    }
}