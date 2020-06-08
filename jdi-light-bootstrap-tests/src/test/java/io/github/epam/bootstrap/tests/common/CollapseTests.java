package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.expandLink;
import static io.github.com.pages.BootstrapPage.hiddenText;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CollapseTests implements TestsInit {
    final String text = "Collapse text shown";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        expandLink.show();
    }

    @Test
    public void expandCollapseTest() {
        hiddenText.is().hidden();
        assertFalse(hiddenText.isDisplayed());
        expandLink.click();
        hiddenText.is().shown();
        assertTrue(hiddenText.isDisplayed());
        expandLink.click();
        hiddenText.is().hidden();
        assertFalse(hiddenText.isDisplayed());
    }
}
