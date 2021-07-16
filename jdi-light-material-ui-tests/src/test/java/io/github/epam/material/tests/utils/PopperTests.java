package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.popperPage;
import static io.github.com.pages.utils.PopperPage.*;

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
    private final static List<String> POPPER_TEXTS = Arrays.asList("", "TOP", "LEFT", "RIGHT", "BOTTOM");
    private final static List<String> TOOLTIP_CLASSES = Arrays.asList("", "top", "left", "right", "bottom");

    @BeforeMethod
    public void beforeTest() {
        popperPage.open();
        popperPage.isOpened();
    }

    @Test
    public void positionedPoppersTest() {
        for (int i = 1; i <= 4; i++) {
            buttons.get(i).click();
            buttons.get(i).has().text(POPPER_TEXTS.get(i));
            tooltip.has().attr("x-placement", TOOLTIP_CLASSES.get(i));
            buttons.get(i).click();
            tooltip.is().notVisible();
        }
    }
}
