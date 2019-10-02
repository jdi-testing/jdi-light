package io.github.epam.bootstrap.tests.common.progress;

import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressBase;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Aleksandr Khmelinin on 2.10.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class ProgressBaseTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] progressWidth() {
        return new Object[][] {
                {progressBase.width0, "width: 0%;"},
                {progressBase.width25, "width: 25%;"},
                {progressBase.width50, "width: 50%;"},
                {progressBase.width75, "width: 75%;"},
                {progressBase.width100, "width: 100%;"},
        };
    }

    @Test(dataProvider = "progressWidth")
    public void getWidthTest(Progress progress, String width) {
        progress.is().width(width);
    }

    @DataProvider
    public static Object[][] progressColor() {
        return new Object[][] {
                {progressBase.width0, "rgba(0, 123, 255, 1)"},
                {progressBase.width25, "rgba(0, 123, 255, 1)"},
                {progressBase.width50, "rgba(0, 123, 255, 1)"},
                {progressBase.width75, "rgba(0, 123, 255, 1)"},
                {progressBase.width100, "rgba(0, 123, 255, 1)"},
        };
    }

    @Test(dataProvider = "progressColor")
    public void getColorTest(Progress progress, String color) {
        progress.is().color(color);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(progressBase.progress0);
        baseValidation(progressBase.progress25);
        baseValidation(progressBase.progress50);
        baseValidation(progressBase.progress75);
        baseValidation(progressBase.progress100);
    }
}
