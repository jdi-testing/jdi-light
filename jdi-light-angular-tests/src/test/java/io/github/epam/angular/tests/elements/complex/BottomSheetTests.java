package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.angular.elements.complex.BottomSheet.BOTTOM_SHEET_VALUES;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BottomSheetSection.bottomSheet;
import static io.github.com.pages.sections.BottomSheetSection.openBottomSheetButton;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BottomSheetTests extends TestsInit {

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
        String[] expectedList = BOTTOM_SHEET_VALUES;
        openBottomSheetButton.click();
        List<String> actualList = bottomSheet.values();
        for (int i = 0; i < expectedList.length; i++) {
            bottomSheet.is().checkValue(expectedList[i], actualList.get(i));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (bottomSheet.isDisplayed()) {
            bottomSheet.doubleClick();
        }
    }
}

