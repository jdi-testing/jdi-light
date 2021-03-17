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

        appBarFrame.appBar.is().enabled(1);
        appBarFrame.appBar.clickOnButtonByIndex(1);
        appBarFrame.appBar.is().enabled(2);
        appBarFrame.appBar.clickOnButtonByIndex(2);
        appBarFrame.appTitle.is().assertTitle(TITLE);
    }
}
