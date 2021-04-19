package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.utils.PopoverPage.*;

public class PopoverTests extends TestsInit {

    @Test
    public void clickPopoverTest() {
        openSection("Popover");

        buttonToClick.is().text("CLICK TO OPEN POPOVER");
        buttonToClick.click();
        popoverContent.is().text("Popover content");
    }

    @Test
    public void hoverPopoverTest() {
        openSection("Popover");

        popoverHoverField.is().text("[Hover to open Popover]");
        popoverHoverField.hover();
        popoverHoverField.has().attr("aria-owns", "mouse-over-popover");
        popoverContent.is().text("Popover content");
    }
}
