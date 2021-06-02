package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.popoverPage;
import static io.github.com.pages.utils.PopoverPage.*;

/**
 * To see an example of Modal web element please visit
 * https://material-ui.com/components/popover/
 */

public class PopoverTests extends TestsInit {

    @BeforeMethod
    public void before() {
        popoverPage.open();
    }

    @Test
    public void clickPopoverTest() {

        buttonToClick.is().text("CLICK TO OPEN POPOVER");
        buttonToClick.click();
        popoverContent.is().text("Popover content");
    }

    @Test
    public void hoverPopoverTest() {

        popoverHoverField.is().text("[Hover to open Popover]");
        popoverHoverField.hover();
        popoverHoverField.has().attr("aria-owns", "mouse-over-popover");
        popoverContent.is().text("Popover content");
    }
}
