package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.displayDataTooltipDefaultPage;
import static io.github.com.StaticSite.displayDataTooltipInteractivePage;
import static io.github.com.StaticSite.tooltipFrame;

public class TooltipTests extends TestsInit {

    @Test
    public void defaultTooltipTest() {
        displayDataTooltipDefaultPage.open();

        tooltipFrame.buttonWithTooltip.hover();
        tooltipFrame.buttonWithTooltip.tooltip().is().visible();
        tooltipFrame.buttonWithTooltip.tooltip().has().text("Add");
    }

    @Test
    public void interactiveTooltipTest() {
        displayDataTooltipInteractivePage.open();

        tooltipFrame.buttonWithTooltip.hover();
        tooltipFrame.buttonWithTooltip.tooltip().is().visible();
        tooltipFrame.buttonWithTooltip.tooltip().is().interactive();
    }

}
