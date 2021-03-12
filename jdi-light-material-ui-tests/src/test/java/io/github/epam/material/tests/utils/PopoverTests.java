package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.popoverClickFrame;
import static io.github.com.StaticSite.popoverHoverFrame;
import static io.github.com.StaticSite.utilsPopoverClickPage;
import static io.github.com.StaticSite.utilsPopoverHoverPage;

public class PopoverTests extends TestsInit {

    private final String EXPECTED_TEXT = "Popover content";
    private final String EXPECTED_TEXT_CAMEL_CASE = "PoPoVeR cOnTeNt";
    private final String EXPECTED_TEXT_PART = "Popover";

    @Test
    public void clickPopoverTest() {
        utilsPopoverClickPage.open();

        popoverClickFrame.popover.is().invisible();
        popoverClickFrame.buttonToClick.core().click();

        popoverClickFrame.popover.is().visible();
        popoverClickFrame.popover.is().textEquals(EXPECTED_TEXT);
        popoverClickFrame.popover.is().textEqualsIgnoreCase(EXPECTED_TEXT_CAMEL_CASE);
        popoverClickFrame.popover.is().textContains(EXPECTED_TEXT_PART);
    }

    @Test
    public void hoverPopoverTest() {
        utilsPopoverHoverPage.open();

        popoverClickFrame.popover.is().invisible();
        popoverHoverFrame.labelToHover.hover();

        popoverClickFrame.popover.is().visible();
        popoverHoverFrame.popover.is().textEquals(EXPECTED_TEXT);
        popoverHoverFrame.popover.is().textEqualsIgnoreCase(EXPECTED_TEXT_CAMEL_CASE);
        popoverHoverFrame.popover.is().textContains(EXPECTED_TEXT_PART);
    }
}
