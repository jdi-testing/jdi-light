package io.github.epam.bootstrap.tests.composite.section.listProgressBars;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;


/**
 * Created by Aleksandr Shiganov on 2.10.2019
 * Email: aleksandr_shiganov@epam.com;
 */

public class ListProgressBarsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] progressValueNow() {
        return new Object[][] {
                {"striped_ordinary", "10", },
                {"striped_success", "25"},
                {"striped_info", "50"},
                {"striped_warning", "75"},
                {"striped_danger", "100"},
        };
    }

    @Test(dataProvider = "progressValueNow")
    public void getWidthTest(String progressId, String value) {
            progressBars.forEach(progressBar -> {
                progressBar.progress.is().ariaValue(value);
            });
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

   /* @Test(dataProvider = "progressColor")
    public void getColorTest(Progress progress, String color) {
        progress.is().color(color);
    }*/


    @Test
    public void baseValidationTest() {
        baseValidation(progressBaseProgress0);
        baseValidation(progressBaseWidth25);
        baseValidation(progressBaseWidth50);
        baseValidation(progressBaseWidth75);
        baseValidation(progressBaseWidth100);
    }
}
