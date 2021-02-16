package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.backdropFrame;
import static io.github.com.StaticSite.feedbackBackdropDefaultPage;

public class BackdropTests extends TestsInit {

    @Test
    public void defaultBackdropTest() {
        feedbackBackdropDefaultPage.open();

        backdropFrame.backdrop.is().hidden();
        backdropFrame.showBackdropButton.click();
        backdropFrame.backdrop.is().visible();
        backdropFrame.backdrop.hide();
        backdropFrame.backdrop.is().hidden();
    }

}
