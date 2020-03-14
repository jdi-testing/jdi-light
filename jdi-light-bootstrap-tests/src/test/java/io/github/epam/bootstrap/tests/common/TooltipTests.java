package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.*;
import static org.testng.AssertJUnit.*;

public class TooltipTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        buttonWithTooltip.show();
        simpleToastButton.hover();
        buttonWithTooltip.tooltip().waitFor().hidden();
    }

    @Test
    public void tooltipTextTest() {
        buttonWithTooltip.hover();
        assertEquals(buttonWithTooltip.tooltip().getText(), "Tooltip at the top");
    }

    @Test
    public void tooltipCheckTest() {
        buttonWithTooltip.hover();
        buttonWithTooltip.tooltip().has().text("Tooltip at the top");
    }

    @Test
    public void noTooltipGetTest() {
        assertEquals(buttonWithTooltip.tooltip().text(), "");
    }

    @Test
    public void tooltipIsDisplayedTest() {
        buttonWithTooltip.hover();
        assertTrue(buttonWithTooltip.tooltip().isDisplayed());
    }

    @Test
    public void tooltipCheckDisplayedTest() {
        buttonWithTooltip.hover();
        buttonWithTooltip.tooltip().is().displayed();
    }

    @Test
    public void tooltipIsHiddenTest() {
        assertTrue(buttonWithTooltip.tooltip().isHidden());
    }

    @Test
    public void tooltipCheckHiddenTest() {
        buttonWithTooltip.tooltip().is().hidden();
    }
}