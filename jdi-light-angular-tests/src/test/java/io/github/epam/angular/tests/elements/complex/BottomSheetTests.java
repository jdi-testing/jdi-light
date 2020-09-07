package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BottomSheetSection.bottomSheet;
import static io.github.com.pages.sections.BottomSheetSection.openBottomSheetButton;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BottomSheetTests extends TestsInit {

    private static final String[] BOTTOM_SHEET_VALUES = {"Google Keep", "Google Docs", "Google Plus", "Google Hangouts"};

    @BeforeClass(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        openBottomSheetButton.show();
    }

    @Test
    public void checkBottomSheetIsDisplayedTest() {
        openBottomSheetButton.click();
        bottomSheet.is().displayed();
    }

    @Test
    public void checkBottomSheetIsHiddenTest() {
        openBottomSheetButton.click();
        bottomSheet.is().displayed();
        bottomSheet.doubleClick();
        bottomSheet.is().hidden();
    }

    @Test
    public void checkBottomSheetAvailableOptionsTest() {
        openBottomSheetButton.click();
        bottomSheet.values().is().values(BOTTOM_SHEET_VALUES);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (bottomSheet.isDisplayed()) {
            bottomSheet.doubleClick();
        }
    }
}

