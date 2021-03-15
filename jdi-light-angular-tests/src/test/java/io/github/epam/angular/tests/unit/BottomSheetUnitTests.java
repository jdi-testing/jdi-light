package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.composite.WebPage.reload;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.bottomSheet;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BottomSheetUnitTests extends TestsInit {
    private static final List<String> BOTTOM_SHEET_VALUES =
            Arrays.asList("Google Keep", "Google Docs", "Google Plus", "Google Hangouts");

    @BeforeClass(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        bottomSheet.show();
    }

    @BeforeMethod
    // required to reload before each test
    public void reloadPage() {
        reload();
        bottomSheet.show();
    }

    @Test
    public void openedTest() {
        bottomSheet.open();
        assertTrue(bottomSheet.isOpened());
    }

    @Test
    public void closedTest() {
        bottomSheet.open();
        bottomSheet.close();
        assertTrue(bottomSheet.isClosed());
    }

    @Test
    public void valuesTest() {
        bottomSheet.open();
        assertEquals(bottomSheet.values(), BOTTOM_SHEET_VALUES);
    }

    @AfterClass
    public void tearDownClass() {
        reload();
    }
}
