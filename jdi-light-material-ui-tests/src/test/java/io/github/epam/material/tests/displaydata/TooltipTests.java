package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tooltipPage;

/**
 * To see an example of Tooltip web element please visit
 * https://material-ui.com/components/tooltips/
 */

public class TooltipTests extends TestsInit {

    @Test
    public void defaultTooltipTest() {
        tooltipPage.open();
        tooltipPage.buttonWithTooltip.hover();
        tooltipPage.buttonWithTooltip.tooltip().is().visible();
        tooltipPage.buttonWithTooltip.tooltip().has().text("Delete");
    }

}
