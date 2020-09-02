package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BottomSheetSection.bottomSheet;
import static io.github.com.pages.sections.BottomSheetSection.openBottomSheetButton;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BottomSheetTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void openBottomSheetButtonTest() {
        openBottomSheetButton.show();
        //openBottomSheetButton.is().displayed();
    }

    @Test
    public void checkBottomSheetIsOpenedTest() {
        openBottomSheetButton.show();
        openBottomSheetButton.click();
        //bottomSheet.is().displayed();

//    @Test
//    public void checkBottomSheetIsClosedTest() {
//        bottomSheet.close();
//        bottomSheet.is().isClosed();
//    }
//
//    @Test
//    public void checkBottomSheetAvailableOptionsTest() {
//
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void after() {
//        if (bottomSheet.isOpened()){
//            bottomSheet.close();
//        }
    }
}

