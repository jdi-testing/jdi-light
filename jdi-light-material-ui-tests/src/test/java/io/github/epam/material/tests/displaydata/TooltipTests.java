package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.displayDataTooltipDefaultPage;
import static io.github.com.StaticSite.tooltipFrame;

public class TooltipTests extends TestsInit {

    @Test
    public void defaultTooltipTest() {
        displayDataTooltipDefaultPage.open();

        tooltipFrame.buttonWithTooltip.hover();
        System.out.println(tooltipFrame.buttonWithTooltip.tooltip().getTagName());
        System.out.println(tooltipFrame.buttonWithTooltip.tooltip().core().classes());
        System.out.println(tooltipFrame.buttonWithTooltip.tooltip().core().getText());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
