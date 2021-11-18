package io.github.epam.material.tests.utils;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.jdiai.tools.Timer;
import static io.github.com.StaticSite.popperPage;
import static io.github.com.pages.utils.PopperPage.popper;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Modal web element please visit
 * https://material-ui.com/components/popper/
 */

public class PopperTests extends TestsInit {
    private final static String[] POPPER_BUTTONS_TEXTS = {"top", "left", "right", "bottom"};
    private final static String POPPER_CONTENT_TEXT = "The content of the Popper.";
    private final static Position[] POPPER_POSITIONS = {Position.TOP, Position.LEFT, Position.RIGHT, Position.BOTTOM};

    @BeforeMethod
    public void beforeTest() {
        popperPage.open();
        popperPage.isOpened();
    }

    @Test
    public void positionedPoppersTest() {
        Timer timer = new Timer(2000L);
        for (int i = 1; i <= 4; i++) {
            popper.popperButton(POPPER_BUTTONS_TEXTS[i - 1]).click();
            popper.assertThat().popperDisplayed();
            popper.assertThat().popperTextCorrect(POPPER_CONTENT_TEXT);
            popper.assertThat().popperPosition(POPPER_POSITIONS[i - 1]);
            popper.popperButton(POPPER_BUTTONS_TEXTS[i - 1]).click();
            timer.wait(() -> popper.assertThat().notVisible());
        }
    }
}
