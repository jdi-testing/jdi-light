package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.appBarFrame;
import static io.github.com.StaticSite.appBarPage;

public class AppBarTests extends TestsInit {

    private static final String TITLE = "News";

    @Test
    public void appBarTests() {
        appBarPage.shouldBeOpened();

        appBarFrame.appBarElement.is().enabled(1);
        appBarFrame.appBarElement.clickOnElementByIndex(1);
        appBarFrame.appBarElement.is().enabled(2);
        appBarFrame.appBarElement.clickOnElementByIndex(2);
        appBarFrame.appTitle.is().assertTitle(TITLE);
    }
}
