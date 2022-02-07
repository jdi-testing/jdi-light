package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.progressPage;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateIndeterminateProgress;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateProgress;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateProgressWithLabel;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateWithValue100;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateWithValue25;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateWithValue50;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateWithValue75;
import static io.github.com.pages.feedback.ProgressPage.circularIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.circularIndeterminateCustomized;
import static io.github.com.pages.feedback.ProgressPage.interactiveIntegrationCircularButton;
import static io.github.com.pages.feedback.ProgressPage.interactiveIntegrationCircularIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.linearBuffer;
import static io.github.com.pages.feedback.ProgressPage.linearDeterminate;
import static io.github.com.pages.feedback.ProgressPage.linearDeterminateCustomized;
import static io.github.com.pages.feedback.ProgressPage.linearIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.linearWithLabel;
import static io.github.com.pages.feedback.ProgressPage.loadingCircularIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.simulateLoadButton;
import static io.github.com.pages.feedback.ProgressPage.simulateLoadCircularIndeterminate;
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
        timer.wait(() -> circularIndeterminate.is().displayed());
        circularIndeterminate.is().indeterminate();
    }

    @Test
    public void circularDeterminateTest() {
        circularDeterminateWithValue25.is().displayed().and().determinate()
                .and().has().value(25).and().primaryColor();
        circularDeterminateWithValue50.is().displayed().and().determinate()
                .and().has().value(50).and().primaryColor();
        circularDeterminateWithValue75.is().displayed().and().determinate()
                .and().has().value(75).and().primaryColor();
        circularDeterminateWithValue100.is().displayed().and().determinate()
                .and().has().value(100).and().primaryColor();

        circularDeterminateProgress.is().displayed().and().determinate()
                .and().has().primaryColor();
        int valueNow = circularDeterminateProgress.getValueNow();
        timer.wait(() -> circularDeterminateProgress.has().value(valueNow + 10));

        circularDeterminateIndeterminateProgress.is().displayed().and().indeterminate()
                .and().has().primaryColor();
        circularDeterminateIndeterminateProgress.circle()
                .has().cssClass("MuiCircularProgress-circleDisableShrink");
    }

    @Test
    public void interactiveIntegrationTest() {
        interactiveIntegrationCircularButton.click();
        interactiveIntegrationCircularIndeterminate.is().indeterminate();
        timer.wait(() -> interactiveIntegrationCircularIndeterminate.is().hidden());
        // TODO: Add check for Accept terms button
    }

    @Test
    public void circularWithLabelTest() {
        circularDeterminateProgressWithLabel.show();
        circularDeterminateProgressWithLabel.is().displayed().and().determinate();
        circularDeterminateProgressWithLabel.label().is().displayed();
        timer.wait(() -> circularDeterminateProgressWithLabel.label().has().text("60%"));
        timer.wait(() -> circularDeterminateProgressWithLabel.has().value(60));
    }

    @Test
    public void linearIndeterminateTest() {
        linearIndeterminate.is().displayed().and().indeterminate();
        linearIndeterminate.has().firstBarColor(Colors.PRIMARY.rgba());

        linearIndeterminate.bar1().is().displayed();
        linearIndeterminate.bar2().is().displayed();
        linearIndeterminate.has().firstBarColor(Colors.PRIMARY.rgba())
                .and().secondBarColor(Colors.PRIMARY.rgba());
    }

    @Test
    public void linearDeterminateTest() {
        linearDeterminate.is().displayed().and().determinate();

        linearDeterminate.has().min(0).and().max(100);
        timer.wait(() -> linearDeterminate.has().value(Matchers.greaterThanOrEqualTo(5)));
        timer.wait(() -> linearDeterminate.has().value(Matchers.greaterThanOrEqualTo(10)));

        linearDeterminate.bar1().is().displayed();
        linearDeterminate.has().firstBarColor(Colors.PRIMARY.rgba());
    }

    @Test
    public void linearBufferTest() {
        linearBuffer.is().displayed().and().determinate().and().buffer();

        linearBuffer.has().min(0).and().max(100);
        timer.wait(() -> linearBuffer.has().value(Matchers.greaterThanOrEqualTo(5)));
        timer.wait(() -> linearBuffer.has().value(Matchers.greaterThanOrEqualTo(10)));
    }

    @Test
    public void linearWithLabelTest() {
        linearWithLabel.is().determinate().and().has().firstBarColor(Colors.PRIMARY.rgba());

        linearWithLabel.has().min(0).and().max(100);
        int valueNow = linearWithLabel.getValueNow();
        linearWithLabel.label().has().text(valueNow + "%");

        int finalValueNow = valueNow;
        timer.wait(() -> linearWithLabel.is().value(Matchers.greaterThan(finalValueNow + 10)));
        valueNow = linearWithLabel.getValueNow();
        linearWithLabel.label().has().text(valueNow + "%");
    }

    @Test
    public void customizedProgressTest() {
        String lightBlueColor = "rgba(26, 144, 255, 1)";
        circularIndeterminateCustomized.isDisplayed();
        circularIndeterminateCustomized.has().color(lightBlueColor);

        linearDeterminateCustomized.isDisplayed();
        linearDeterminateCustomized.has().firstBarColor(lightBlueColor);
    }

    @Test
    public void delayingAppearanceTest() {
        startLoadingButton.click();
        loadingCircularIndeterminate.is().indeterminate();
        simulateLoadButton.click();
        simulateLoadCircularIndeterminate.is().indeterminate();
        timer.wait(() -> successMessage.is().displayed());
    }
}
