package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.bootstrap.elements.common.Tooltips;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonWithTooltip;
import static io.github.com.pages.BootstrapPage.simpleToastButton;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.*;

//TODO
public class TooltipTests extends TestsInit {
    Thread showHideTooltipAction() {
        return new Thread(() -> {
            Timer.sleep(500);
            buttonWithTooltip.hover();
            Timer.sleep(500);
            simpleToastButton.show();
        });
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        buttonWithTooltip.show();
        simpleToastButton.hover();
        Tooltips.checkTooltipIsHiddenFor(buttonWithTooltip);
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
    public void tooltipIsHiddenTest() {
        boolean isHidden = Tooltips.isHiddenFor(buttonWithTooltip);
        assertTrue(isHidden);
    }
    @Test
    public void tooltipCheckHiddenTest() {
        Tooltips.checkTooltipIsHiddenFor(buttonWithTooltip);
    }
    @Test(enabled = false)
    public void tooltipIsDisappearTest() {
        showHideTooltipAction().start();
        boolean isHidden = Tooltips.tooltip("Tooltip at the top").isDisappearFor(buttonWithTooltip);
        assertTrue(isHidden);
    }
    @Test(enabled = false)
    public void tooltipCheckDisappearTest() {
        showHideTooltipAction().start();
        Tooltips.tooltip("Tooltip at the top").checkDisappearFor(buttonWithTooltip);
    }
    @Test
    public void noTooltipGetTest() {
        String tooltip = Tooltips.getTooltipFor(buttonWithTooltip);
        assertEquals(tooltip, "");
    }
    @Test
    public void noTooltipIsTest() {
        boolean isDisplayed = Tooltips.tooltip("Tooltip at the top").isDisplayedFor(buttonWithTooltip);
        assertFalse(isDisplayed);
    }
    @Test
    public void noTooltipCheckTest() {
        try {
            Tooltips.tooltip("Tooltip at the top").checkDisplayedFor(buttonWithTooltip);
            Assert.fail();
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("Failed to execute 'checkDisplayedFor' for element"));
        }
    }
}
