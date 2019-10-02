package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressWithLabels;
import static io.github.com.pages.BootstrapPage.plus;
import static io.github.com.pages.BootstrapPage.minus;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProgressWithLabelsTests extends TestsInit {

    private String defaultPercent = "25%";

    @BeforeMethod

    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(progressWithLabels);
        baseValidation(plus);
        baseValidation(minus);
    }

    @Test
    public void isValidationTest() {
        progressWithLabels.is().displayed();
        progressWithLabels.is().enabled();
        assertThat(progressWithLabels.core().css("font-size"), is("12px"));
        progressWithLabels.assertThat().displayed()
                .core()
                .css("font-size", is("12px"))
                .cssClass("progress-bar")
                .attr("role", "progressbar")
                .attr("aria-valuenow", "25")
                .attr("aria-valuemin", "0")
                .attr("aria-valuemax", "100")
                .tag(is("div"));
    }

    @Test
    public void getDefaultPercentTest() {
        assertThat(progressWithLabels.core().getText(), is(defaultPercent));
    }

    @Test
    public void getPercentTest() {
        assertThat(progressWithLabels.core().getText(), is(defaultPercent));
        minus.click();
        assertThat(progressWithLabels.core().getText(), is("20%"));
        for (int i = 0; i < 10; i++) {
            minus.click();
        }
        assertThat(progressWithLabels.core().getText(), is("0%"));
        plus.click();
        assertThat(progressWithLabels.core().getText(), is("5%"));
        for (int i = 0; i < 30; i++) {
            plus.click();
        }
        assertThat(progressWithLabels.core().getText(), is("100%"));

    }
}
