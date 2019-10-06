package io.github.epam.bootstrap.tests.composite.section.listProgressBars;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


/**
 * Created by Aleksandr Shiganov on 3.10.2019
 * Email: aleksandr_shiganov@epam.com;
 */

public class ProgressBarsListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] progressData() {
        return new Object[][]{
                {"striped_ordinary", "10", "rgba(0, 123, 255, 1)", "0", "100", "progress-bar-striped"},
                {"striped_success", "25", "rgba(40, 167, 69, 1)", "0", "100", "progress-bar-striped"},
                {"striped_info", "50", "rgba(23, 162, 184, 1)", "0", "100", "progress-bar-striped"},
                {"striped_warning", "75", "rgba(255, 193, 7, 1)", "0", "100", "progress-bar-striped"},
                {"striped_danger", "100", "rgba(220, 53, 69, 1)", "0", "100", "progress-bar-striped"}
        };
    }

    @Test(dataProvider = "progressData")
    public void checkProgressData(String progressId, String value, String color,
                                  String min, String max, String classStriped) {

        progressSections.stream().filter(progressSection ->
                progressSection.progress.attr("id").equals(progressId)).forEach(
                progressSection -> {
                    progressSection.progress.is().ariaValue(value);
                    progressSection.progress.is().color(color);
                    progressSection.progress.is().minValue(min);
                    progressSection.progress.is().maxValue(max);
                    assertThat(progressSection.progress.core().attr("class"),
                            containsString(classStriped));
                });
    }

    @Test
    public void baseValidationTest() {
        progressSections.forEach(
                progressSection ->
                        baseValidation(progressSection.progress));

    }
}
