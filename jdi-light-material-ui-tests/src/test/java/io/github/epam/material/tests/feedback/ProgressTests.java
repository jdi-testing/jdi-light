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
    public void progressTest() {
        circularDefault.is().indeterminate();
        int valueNow = circularIndeterminate.getValueNow();
        timer.wait(() ->circularIndeterminate.is().value(valueNow + 10));
        circularDefault.is().indeterminate();
        interactiveIntegrationCircularButton.click();
        interactiveIntegrationCircularIndeterminate.is().indeterminate();
        startLoadingButton.click();
        loadingCircularIndeterminate.is().indeterminate();
        simulateLoadButton.click();
        simulateLoadCircularIndeterminate.is().indeterminate();
        timer.wait(() -> successMessage.is().displayed());
    }
}
