package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.bottomSheet;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BottomSheetTests extends TestsInit {
    private static final List<String> BOTTOM_SHEET_VALUES = Arrays.asList("Google Keep", "Google Docs", "Google Plus", "Google Hangouts");

    @BeforeClass(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.open();
        bottomSheet.show();
    }

    @Test
    public void checkBottomSheetIsDisplayedTest() {
        bottomSheet.open();
        bottomSheet.is().opened();
    }

    @Test
    public void checkBottomSheetIsHiddenTest() {
        bottomSheet.open();
        bottomSheet.close();
        bottomSheet.is().closed();
    }

    @Test
    public void checkBottomSheetAvailableOptionsTest() {
        bottomSheet.open();
        bottomSheet.is().values(BOTTOM_SHEET_VALUES);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (bottomSheet.isOpened()) {
            bottomSheet.close();
        }
    }
}

