package io.github.epam.material.tests.feedback;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.progressPage;
import static io.github.com.pages.feedback.ProgressPage.circularDeterminateCustomized;
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
import static io.github.com.pages.feedback.ProgressPage.linearIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.linearWithLabel;
import static io.github.com.pages.feedback.ProgressPage.loadingCircularIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.simulateLoadButton;
import static io.github.com.pages.feedback.ProgressPage.simulateLoadCircularIndeterminate;
import static io.github.com.pages.feedback.ProgressPage.startLoadingButton;
import static io.github.com.pages.feedback.ProgressPage.successMessage;

public class ProgressTests extends TestsInit {
    private Timer timer = new Timer(5000L);

    @BeforeMethod
    public void beforeTest() {
        progressPage.open();
        progressPage.isOpened();
    }

    @Test
    public void progressSimpleTest() {
        timer.wait(() -> circularIndeterminate.isDisplayed());
        circularDeterminateWithValue25.isDisplayed();
        circularDeterminateWithValue50.isDisplayed();
        circularDeterminateWithValue75.isDisplayed();
        circularDeterminateWithValue100.isDisplayed();
        circularDeterminateProgress.isDisplayed();
        circularDeterminateProgressWithLabel.isDisplayed();
        circularIndeterminateCustomized.isDisplayed();
        circularDeterminateCustomized.isDisplayed();
        interactiveIntegrationCircularButton.isDisplayed();
        linearIndeterminate.isDisplayed();
        linearDeterminate.isDisplayed();
        linearBuffer.isDisplayed();
        linearWithLabel.isDisplayed();
    }

    @Test
    public void circularProgressTest() {
        circularIndeterminate.is().indeterminate();
        int valueNow = circularDeterminateProgress.getValueNow();
        timer.wait(() -> circularDeterminateProgress.is().value(valueNow + 10));
        circularDeterminateProgress.is().determinate();
    }

    @Test
    public void circularProgressButtonsTest() {
        interactiveIntegrationCircularButton.click();
        interactiveIntegrationCircularIndeterminate.is().indeterminate();
        startLoadingButton.click();
        loadingCircularIndeterminate.is().indeterminate();
        simulateLoadButton.click();
        simulateLoadCircularIndeterminate.is().indeterminate();
        timer.wait(() -> successMessage.is().displayed());
    }

    @Test
    public void linearProgressTest() {
        linearIndeterminate.is().indeterminate();
        linearBuffer.is().buffer();
        int valueNow1 = linearDeterminate.getValueNow();
        timer.wait(() -> linearDeterminate.is().value(valueNow1 + 10));
        int valueNow2 = linearBuffer.getValueNow();
        timer.wait(() -> linearBuffer.is().value(valueNow2 + 10));
        int valueNow3 = linearWithLabel.getValueNow();
        timer.wait(() -> linearWithLabel.is().value(valueNow3 + 10));
    }
}