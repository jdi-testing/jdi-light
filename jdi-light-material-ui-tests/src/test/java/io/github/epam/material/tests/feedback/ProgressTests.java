package io.github.epam.material.tests.feedback;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.progressPage;
import static io.github.com.pages.feedback.ProgressPage.*;

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
        circularDeterminate1.isDisplayed();
        circularDeterminate2.isDisplayed();
        circularDeterminate3.isDisplayed();
        circularDeterminate4.isDisplayed();
        circularDeterminate5.isDisplayed();
        circularDeterminate6.isDisplayed();
        circularDeterminate7.isDisplayed();
        circularDeterminate8.isDisplayed();
        circularDeterminate9.isDisplayed();
        interactiveIntegrationCircularButton.isDisplayed();
        linearIndeterminate.isDisplayed();
        linearDeterminate.isDisplayed();
        linearBuffer.isDisplayed();
        linearWithLabel.isDisplayed();
        delayingAppearance.isDisplayed();
    }

    @Test
    public void circularProgressTest() {
        circularIndeterminate.is().indeterminate();
        int valueNow = circularDeterminate6.getValueNow();
        timer.wait(() -> circularDeterminate6.is().value(valueNow + 10));
        circularIndeterminate.is().indeterminate();
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
        int valueNow1 = linearDeterminate.getValueNow();
        timer.wait(() -> linearDeterminate.is().value(valueNow1 + 10));
        int valueNow2 = linearBuffer.getValueNow();
        timer.wait(() -> linearBuffer.is().value(valueNow2 + 10));
        int valueNow3 = linearWithLabel.getValueNow();
        timer.wait(() -> linearWithLabel.is().value(valueNow3 + 10));
    }
}
