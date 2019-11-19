package io.github.epam.tests.nonstatic;

import io.github.epam.NonStaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NonStaticSiteTests extends NonStaticTestsInit {

    @BeforeMethod
    public void before() {
        nonStaticSite.shouldBeLoggedIn();
        nonStaticSite.getHomePage().shouldBeOpened();
    }

    @Test
    public void isOpenedTest() {
        nonStaticSite.getHomePage().isOpened();
    }
}
