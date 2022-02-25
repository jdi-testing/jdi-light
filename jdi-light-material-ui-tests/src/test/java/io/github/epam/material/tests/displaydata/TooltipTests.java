package io.github.epam.material.tests.displaydata;

import io.github.com.custom.TooltipButton;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tooltipPage;
import static io.github.com.pages.displaydata.TooltipPage.clickButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.focusOrTouchButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.hoverButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.hoverOrTouchButtonWithTooltip;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Tooltip web element please visit
 * https://material-ui.com/components/tooltips/
 */

public class TooltipTests extends TestsInit {

    @BeforeMethod
    public void before() {
        tooltipPage.open();
        tooltipPage.isOpened();
    }

    @Test
    public void hoverOrTouchTooltip() {
        checkTooltip(hoverOrTouchButtonWithTooltip, "Add");
    }

    @Test
    public  void focusButtonTooltipTest() {
        focusOrTouchButtonWithTooltip.core().focus();
        focusOrTouchButtonWithTooltip.tooltip().is().visible();
        focusOrTouchButtonWithTooltip.tooltip().has().text("Add");
    }

    @Test
    public void hoverButtonTooltipTest() {
        checkTooltip(hoverButtonWithTooltip, "Add");
    }

    @Test
    public void clickButtonTooltipTest() {
        clickButtonWithTooltip.is().visible();
        clickButtonWithTooltip.click();
        clickButtonWithTooltip.tooltip().is().visible();
        clickButtonWithTooltip.tooltip().has().text("Add");
    }

    private static void checkTooltip(TooltipButton tooltipButton, String expectedText) {
        tooltipButton.hover();
        tooltipButton.tooltip().is().visible();
        tooltipButton.tooltip().has().text(containsString(expectedText));
    }

}

