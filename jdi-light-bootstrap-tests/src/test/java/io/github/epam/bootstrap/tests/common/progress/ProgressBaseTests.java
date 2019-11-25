package io.github.epam.bootstrap.tests.common.progress;

import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressBaseWidth0;
import static io.github.com.pages.BootstrapPage.progressBaseWidth25;
import static io.github.com.pages.BootstrapPage.progressBaseWidth50;
import static io.github.com.pages.BootstrapPage.progressBaseWidth75;
import static io.github.com.pages.BootstrapPage.progressBaseWidth100;
import static io.github.com.pages.BootstrapPage.progressBaseProgress0;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
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
                {progressBaseWidth0, "0"},
                {progressBaseWidth25, "25"},
                {progressBaseWidth50, "50"},
                {progressBaseWidth75, "75"},
                {progressBaseWidth100, "100"},
        };
    }

    @Test(dataProvider = "progressWidth")
    public void getWidthTest(Progress progress, String width) {
        progress.is().value(width);
    }

    @DataProvider
    public static Object[][] progressColor() {
        return new Object[][] {
                {progressBaseWidth0, "rgba(0, 123, 255, 1)"},
                {progressBaseWidth25, "rgba(0, 123, 255, 1)"},
                {progressBaseWidth50, "rgba(0, 123, 255, 1)"},
                {progressBaseWidth75, "rgba(0, 123, 255, 1)"},
                {progressBaseWidth100, "rgba(0, 123, 255, 1)"},
        };
    }

    @Test(dataProvider = "progressColor")
    public void getColorTest(Progress progress, String color) {
        progress.is().color(color);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(progressBaseProgress0);
        baseValidation(progressBaseWidth25);
        baseValidation(progressBaseWidth50);
        baseValidation(progressBaseWidth75);
        baseValidation(progressBaseWidth100);
    }
}
