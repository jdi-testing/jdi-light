package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.backdropPage;
import static io.github.com.pages.feedback.BackdropPage.backdrop;
import static io.github.com.pages.feedback.BackdropPage.showBackdropButton;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Backdrop web element please visit
 * https://material-ui.com/components/backdrop/
 */

public class BackdropTests extends TestsInit {

    @BeforeMethod
    public void before() {
        backdropPage.open();
        backdropPage.isOpened();
    }

    @Test
    public void defaultBackdropTest() {
        showBackdropButton.click();
        backdrop.is().visible();
        backdrop.core().click();
        backdrop.is().hidden();
    }
}
