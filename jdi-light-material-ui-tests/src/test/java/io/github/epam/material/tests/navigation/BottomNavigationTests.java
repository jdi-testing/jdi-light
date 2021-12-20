package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bottomNavigationPage;
import static io.github.com.pages.navigation.BottomNavigationPage.bottomNavigationItems;

public class BottomNavigationTests extends TestsInit {

    @BeforeMethod
    public void before() {
        bottomNavigationPage.open();
        bottomNavigationPage.checkOpened();
    }

    @Test
    public void defaultBottomNavigationTest() {
        bottomNavigationItems.select(2);
        bottomNavigationItems.has().selected(2);
    }
}