package io.github.epam.material.tests.feedback;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.backdropPage;
import static io.github.com.pages.feedback.BackdropPage.backdrop;
import static io.github.com.pages.feedback.BackdropPage.showBackdropButton;

public class BackdropTests extends TestsInit {

    private static final Timer timer = new Timer(1000L);

    @BeforeMethod
    public void before() {
        backdropPage.open();
    }

    @Test
    public void defaultBackdropTest() {

        showBackdropButton.click();
        timer.wait(() -> backdrop.is().visible());
        backdrop.click();
        timer.wait(() -> backdrop.is().hidden());
    }
}
