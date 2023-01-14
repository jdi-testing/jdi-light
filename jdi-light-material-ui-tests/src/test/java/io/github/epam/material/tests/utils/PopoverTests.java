package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.popoverPage;
import static io.github.com.pages.utils.PopoverPage.popover;
import static io.github.com.pages.utils.PopoverPage.popoverButton;
import static io.github.com.pages.utils.PopoverPage.popoverButtonHover;

public class PopoverTests extends TestsInit {

    private static final String POPOVER_CONTENT = "Popover content";

    @BeforeMethod
    public void before() {
        popoverPage.open();
        popoverPage.isOpened();
    }

    @Test
    public void clickPopoverTest() {
        popoverButton.click();
        popover.has().text(POPOVER_CONTENT);
        popover.close();
        popover.is().notVisible();
    }

    @Test
    public void hoverPopoverTest() {
        popoverButtonHover.click();
        popoverButtonHover.has().attr("aria-owns", "mouse-over-popover");
        popover.has().text(POPOVER_CONTENT);
        popover.close();
        popover.is().notVisible();
    }
}
