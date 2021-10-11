package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.popperPage;
import static io.github.com.pages.utils.PopperPage.buttons;
import static io.github.com.pages.utils.PopperPage.popper;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * To see an example of Modal web element please visit
 * https://material-ui.com/components/popper/
 */

public class PopperTests extends TestsInit {
    private final static List<String> POPPER_BUTTONS_TEXTS = Arrays.asList("TOP", "LEFT", "RIGHT", "BOTTOM");
    private final static String POPPER_CONTENT_TEXT = "The content of the Popper.";
    private final static Position[] POPPER_POSITIONS = { Position.TOP, Position.LEFT, Position.RIGHT, Position.BOTTOM };

    @BeforeMethod
    public void beforeTest() {
        popperPage.open();
        popperPage.isOpened();
    }

    @Test
    public void positionedPoppersTest() {
        Timer timer = new Timer(2000L);
        for (int i = 1; i <= 4; i++) {
            buttons.get(i).click();
            buttons.get(i).has().text(POPPER_BUTTONS_TEXTS.get(i - 1));
            popper.is().popperDisplayed();
            popper.is().popperTextCorrect(POPPER_CONTENT_TEXT);
            popper.is().popperPosition(POPPER_POSITIONS[i - 1]);
            buttons.get(i).click();
            timer.wait(() -> popper.is().notVisible());
        }
    }
}
