package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.bottomSheet;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

// TODO Move to the new page
@Ignore
public class BottomSheetTests extends TestsInit {
    private static final List<String> BOTTOM_SHEET_VALUES = Arrays.asList("Google Keep", "Google Docs", "Google Plus", "Google Hangouts");

    @BeforeClass(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        bottomSheet.show();
    }

    @Test
    public void checkBottomSheetAvailableOptionsTest() {
        bottomSheet.open();
        bottomSheet.is().opened();
        bottomSheet.is().values(BOTTOM_SHEET_VALUES);
        bottomSheet.close();
        bottomSheet.is().closed();
    }
}

