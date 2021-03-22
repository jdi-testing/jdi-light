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

        appBarFrame.appBar.getButtonByIndex(1).is().enabled();
        appBarFrame.appBar.getButtonByIndex(1).click();
        appBarFrame.appBar.getButtonByIndex(2).is().enabled();
        appBarFrame.appBar.getButtonByIndex(2).click();
        appBarFrame.appBar.is().assertTitle(TITLE);
        appBarFrame.appBar.getButtonByText(BUTTON_TITLE).is().enabled();
        appBarFrame.appBar.getButtonByText(BUTTON_TITLE).click();
    }
}
