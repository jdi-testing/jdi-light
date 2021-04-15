package io.github.epam.material.tests.feedback;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.feedback.BackdropPage.*;

public class BackdropTests extends TestsInit {

    private static Timer timer = new Timer(1000L);

    @Test
    public void defaultBackdropTest() {
        openSection("Backdrop");

        timer.wait(() -> backdrop.is().hidden());
        showBackdropButton.click();
        backdrop.is().visible();
        backdrop.hide();
        timer.wait(() -> backdrop.is().hidden());
    }
}
