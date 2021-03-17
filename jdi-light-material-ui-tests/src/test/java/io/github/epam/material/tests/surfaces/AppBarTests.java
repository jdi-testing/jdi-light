package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.appBarFrame;
import static io.github.com.StaticSite.appBarPage;

public class AppBarTests extends TestsInit {

    private static final String TITLE = "News";
    private static final String BUTTON_TITLE = "LOGIN";

    @Test
    public void appBarTests() {
        appBarPage.open();

        appBarFrame.appBar.is().buttonByIndexEnabled(1);
        appBarFrame.appBar.clickOnButtonByIndex(1);
        appBarFrame.appBar.is().buttonByIndexEnabled(2);
        appBarFrame.appBar.clickOnButtonByIndex(2);
        appBarFrame.appBar.is().assertTitle(TITLE);
        appBarFrame.appBar.is().assertButtonText(2, BUTTON_TITLE);
    }
}
