package io.github.epam.bootstrap.tests.common.progress;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.minus;
import static io.github.com.pages.BootstrapPage.plus;
import static io.github.com.pages.BootstrapPage.progressWithLabels;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProgressWithLabelsTests extends TestsInit {

    private String defaultPercent = "25%";
    private String minPercent = "0%";
    private String maxPercent = "100%";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        bsPage.refresh();
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
                .tag(is("div"));
        progressWithLabels.core().is()
                .attr("role", "progressbar")
                .attr("aria-valuenow", "25")
                .attr("aria-valuemin", "0")
                .attr("aria-valuemax", "100");
    }

    @Test
    public void getDefaultPercentTest() {
        assertThat(progressWithLabels.core().getText(), is(defaultPercent));
    }

    @Test
    public void getPercentTest() {
        progressWithLabels.core().is().text(defaultPercent);
        minus.click();
        progressWithLabels.core().is().text("20%");
        for (int i = 0; i < 10; i++) {
            minus.click();
        }
        progressWithLabels.core().is().text(minPercent);
        plus.click();
        progressWithLabels.core().is().text("5%");
        for (int i = 0; i < 30; i++) {
            plus.click();
        }
        progressWithLabels.core().is().text(maxPercent);
    }
}
