package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.progressPage;
import static io.github.com.pages.feedback.ProgressPage.acceptTermsButton;
import static io.github.com.pages.feedback.ProgressPage.acceptTermsCircularProgress;
import static io.github.com.pages.feedback.ProgressPage.circularProgressDeterminate;
import static io.github.com.pages.feedback.ProgressPage.circularProgressDeterminateIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.circularProgressDeterminateWithValue100;
import static io.github.com.pages.feedback.ProgressPage.circularProgressDeterminateWithValue25;
import static io.github.com.pages.feedback.ProgressPage.circularProgressDeterminateWithValue50;
import static io.github.com.pages.feedback.ProgressPage.circularProgressDeterminateWithValue75;
import static io.github.com.pages.feedback.ProgressPage.circularProgressIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.circularProgressWithLabel;
import static io.github.com.pages.feedback.ProgressPage.customizedCircularProgress;
import static io.github.com.pages.feedback.ProgressPage.customizedLinearProgress;
import static io.github.com.pages.feedback.ProgressPage.linearProgressBuffer;
import static io.github.com.pages.feedback.ProgressPage.linearProgressDeterminate;
import static io.github.com.pages.feedback.ProgressPage.linearProgressIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.linearProgressWithLabel;
import static io.github.com.pages.feedback.ProgressPage.loadingCircularProgress;
import static io.github.com.pages.feedback.ProgressPage.saveButton;
import static io.github.com.pages.feedback.ProgressPage.saveCircularProgress;
import static io.github.com.pages.feedback.ProgressPage.simulateLoadButton;
import static io.github.com.pages.feedback.ProgressPage.simulateLoadCircularProgress;
import static io.github.com.pages.feedback.ProgressPage.startLoadingButton;
import static io.github.com.pages.feedback.ProgressPage.successMessage;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressTests extends TestsInit {

    private final Timer timer = new Timer(16000L);

    @BeforeMethod
    public void openPage() {
        progressPage.open();
        progressPage.isOpened();
    }

    @Test
    public void circularIndeterminateTest() {
        timer.wait(() -> circularProgressIndeterminate.is().displayed());
        circularProgressIndeterminate.core().show();
        circularProgressIndeterminate.is().indeterminate();
    }

    @Test
    public void circularDeterminateTest() {
        circularProgressDeterminateWithValue25.core().show();
        circularProgressDeterminateWithValue25.is().displayed().and().determinate()
            .and().has().value(25);
        circularProgressDeterminateWithValue50.is().displayed().and().determinate()
            .and().has().value(50);
        circularProgressDeterminateWithValue75.is().displayed().and().determinate()
            .and().has().value(75);
        circularProgressDeterminateWithValue100.is().displayed().and().determinate()
            .and().has().value(100);

        circularProgressDeterminate.is().displayed().and().determinate();
        int valueNow = circularProgressDeterminate.getValueNow();
        timer.wait(() -> circularProgressDeterminate.has().value(valueNow + 10));

        circularProgressDeterminateIndeterminate.is().displayed().and().indeterminate();
        circularProgressDeterminateIndeterminate.circle()
            .has().cssClass("MuiCircularProgress-circleDisableShrink");
    }

    @Test
    public void interactiveIntegrationTest() {
        saveButton.core().show();
        saveButton.click();
        saveCircularProgress.is().indeterminate();
        timer.wait(() -> saveCircularProgress.is().hidden());

        acceptTermsButton.click();
        acceptTermsCircularProgress.is().indeterminate();
        timer.wait(() -> acceptTermsCircularProgress.is().hidden());
    }

    @Test
    public void circularWithLabelTest() {
        circularProgressWithLabel.show();
        circularProgressWithLabel.is().displayed().and().determinate();
        circularProgressWithLabel.label().is().displayed();
        timer.wait(() -> circularProgressWithLabel.label().has().text("60%"));
        timer.wait(() -> circularProgressWithLabel.has().value(60));
    }

    @Test
    public void linearIndeterminateTest() {
        linearProgressIndeterminate.core().show();
        linearProgressIndeterminate.is().displayed().and().indeterminate();
        linearProgressIndeterminate.has().firstBarColor(Colors.INDIGO_500.rgba());

        linearProgressIndeterminate.firstBar().is().displayed();
        linearProgressIndeterminate.secondBar().is().displayed();
        linearProgressIndeterminate.has().firstBarColor(Colors.INDIGO_500.rgba())
            .and().secondBarColor(Colors.INDIGO_500.rgba());
    }

    @Test
    public void linearDeterminateTest() {
        linearProgressDeterminate.core().show();
        linearProgressDeterminate.is().displayed().and().determinate();

        linearProgressDeterminate.has().min(0).and().max(100);
        timer.wait(() -> linearProgressDeterminate.has().value(Matchers.greaterThanOrEqualTo(5)));
        timer.wait(() -> linearProgressDeterminate.has().value(Matchers.greaterThanOrEqualTo(10)));

        linearProgressDeterminate.firstBar().is().displayed();
        linearProgressDeterminate.has().firstBarColor(Colors.INDIGO_500.rgba());
    }

    @Test
    public void linearBufferTest() {
        linearProgressBuffer.core().show();
        linearProgressBuffer.is().displayed().and().determinate().and().buffer();

        linearProgressBuffer.has().min(0).and().max(100);
        timer.wait(() -> linearProgressBuffer.has().value(Matchers.greaterThanOrEqualTo(5)));
        timer.wait(() -> linearProgressBuffer.has().value(Matchers.greaterThanOrEqualTo(10)));
    }

    @Test
    public void linearWithLabelTest() {
        linearProgressWithLabel.core().show();
        linearProgressWithLabel.is().determinate().and().has().firstBarColor(Colors.INDIGO_500.rgba());

        linearProgressWithLabel.has().min(0).and().max(100);
        int valueNow = linearProgressWithLabel.getValueNow();
        linearProgressWithLabel.label().has().text(valueNow + "%");

        int finalValueNow = valueNow;
        timer.wait(() -> linearProgressWithLabel.is().value(Matchers.greaterThan(finalValueNow + 10)));
        valueNow = linearProgressWithLabel.getValueNow();
        linearProgressWithLabel.label().has().text(valueNow + "%");
    }

    @Test
    public void customizedProgressTest() {
        String lightBlueColor = "rgba(26, 144, 255, 1)";
        customizedCircularProgress.core().show();
        customizedCircularProgress.isDisplayed();
        customizedCircularProgress.has().color(lightBlueColor);

        customizedLinearProgress.isDisplayed();
        customizedLinearProgress.has().firstBarColor(lightBlueColor);
    }

    @Test
    public void delayingAppearanceTest() {
        startLoadingButton.core().show();
        startLoadingButton.click();
        loadingCircularProgress.is().indeterminate();

        simulateLoadButton.core().show();
        simulateLoadButton.click();
        simulateLoadCircularProgress.is().indeterminate();
        timer.wait(() -> successMessage.is().displayed());
    }
}
