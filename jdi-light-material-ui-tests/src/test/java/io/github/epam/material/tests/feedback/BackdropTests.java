package io.github.epam.material.tests.feedback;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.github.com.StaticSite.backdropPage;
import static io.github.com.pages.feedback.BackdropPage.*;

public class BackdropTests extends TestsInit {

    private static Timer timer = new Timer(1000L);

    @BeforeTest
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
