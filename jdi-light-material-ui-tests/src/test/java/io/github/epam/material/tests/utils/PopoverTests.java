package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.popoverPage;
import static io.github.com.pages.utils.PopoverPage.popover;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Modal web element please visit
 * https://material-ui.com/components/popover/
 */

public class PopoverTests extends TestsInit {

    private static final String CLICK_BUTTON = "Click to open Popover";
    private static final String HOVER_BUTTON = "Hover to open Popover";
    private static final String POPOVER_CONTENT = "Popover content";

    @BeforeMethod
    public void before() {
        popoverPage.open();
    }

    @Test
    public void clickPopoverTest() {
        popover.button(CLICK_BUTTON).click();
        popover.is().text(POPOVER_CONTENT);
        popover.button(CLICK_BUTTON).click(1, 0);
        popover.is().notVisible();
    }

    @Test
    public void hoverPopoverTest() {
        popover.button(HOVER_BUTTON).hover();
        popover.button(HOVER_BUTTON).has().attr("aria-owns", "mouse-over-popover");
        popover.is().text(POPOVER_CONTENT);
        popover.button(CLICK_BUTTON).hover();
        popover.is().notVisible();
    }
}
