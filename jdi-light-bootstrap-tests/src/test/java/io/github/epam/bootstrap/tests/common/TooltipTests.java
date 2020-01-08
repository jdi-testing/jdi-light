package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.ui.bootstrap.elements.common.Tooltips;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonWithTooltip;
import static io.github.com.pages.BootstrapPage.simpleToastButton;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.AssertJUnit.*;

public class TooltipTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        buttonWithTooltip.show();
        simpleToastButton.hover();
    }

    @Test
    public void tooltipTextTest() {
        buttonWithTooltip.hover();
        String tooltip = Tooltips.getTooltipFor(buttonWithTooltip);
        assertEquals(tooltip, "Tooltip at the top");
    }

    @Test
    public void tooltipIsDisplayedTest() {
        buttonWithTooltip.hover();
        boolean isDisplayed = Tooltips.tooltip("Tooltip at the top").isDisplayedFor(buttonWithTooltip);
        assertTrue(isDisplayed);
    }
    @Test
    public void tooltipCheckTest() {
        buttonWithTooltip.hover();
        Tooltips.tooltip("Tooltip at the top").checkDisplayedFor(buttonWithTooltip);
    }

    @Test
    public void noTooltipTest() {
        String tooltip = Tooltips.getTooltipFor(buttonWithTooltip);
        assertEquals(tooltip, "");
        boolean isDisplayed = Tooltips.tooltip("Tooltip at the top").isDisplayedFor(buttonWithTooltip);
        assertFalse(isDisplayed);
        try {
            Tooltips.tooltip("Tooltip at the top").checkDisplayedFor(buttonWithTooltip);
            Assert.fail();
        } catch (Exception ex) {
            assertEquals(ex.getMessage(), "");
        }
    }
}
