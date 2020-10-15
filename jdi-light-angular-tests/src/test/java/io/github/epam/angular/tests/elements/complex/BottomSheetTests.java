package io.github.epam.angular.tests.elements.complex;


import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.bottomSheet;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BottomSheetTests extends TestsInit {

    private static final String BOTTOM_SHEET_VALUES = "Google Keep\nAdd to a note\nGoogle Docs\nEmbed in a document\nGoogle Plus\nShare with your friends\nGoogle Hangouts\nShow to your coworkers";

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
        try {
            bottomSheet.open();
            bottomSheet.base().wait(30);
            bottomSheet.close();
            bottomSheet.base().wait(30);
            bottomSheet.is().closed();
        } catch (InterruptedException e) {
            e.printStackTrace();
            e.getCause();
            e.getMessage();
        }
    }

    @Test
    public void checkBottomSheetAvailableOptionsTest() {
        bottomSheet.open();
        bottomSheet.is().values(Collections.singletonList(BOTTOM_SHEET_VALUES));
    }
}

