package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tooltipPage;
import static io.github.com.pages.displaydata.TooltipPage.addButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.buttonWithBootstrapTooltip;
import static io.github.com.pages.displaydata.TooltipPage.buttonWithHtmlTooltip;
import static io.github.com.pages.displaydata.TooltipPage.buttonWithLightTooltip;
import static io.github.com.pages.displaydata.TooltipPage.clickButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.deleteButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.disabledButtonWithTooltip;
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
    public void deleteButtonWithTooltipTest() {
        deleteButtonWithTooltip.is().visible();
        deleteButtonWithTooltip.hover();
        deleteButtonWithTooltip.tooltip().is().visible();
        deleteButtonWithTooltip.tooltip().has().text("Delete");
    }

    @Test
    public void addButtonWithTooltipTest() {
        addButtonWithTooltip.is().visible();
        addButtonWithTooltip.hover();
        addButtonWithTooltip.tooltip().is().visible();
        addButtonWithTooltip.tooltip().has().text("Add");
    }

    @Test
    public void buttonWithLightTooltipTest() {
        buttonWithLightTooltip.is().visible();
        buttonWithLightTooltip.hover();
        buttonWithLightTooltip.tooltip().is().visible();
        buttonWithLightTooltip.tooltip().has().text("Add");
    }

    @Test
    public void buttonWithBootstrapTooltipTest() {
        buttonWithBootstrapTooltip.is().visible();
        buttonWithBootstrapTooltip.hover();
        buttonWithBootstrapTooltip.tooltip().is().visible();
        buttonWithBootstrapTooltip.tooltip().has().text("Add");
    }

    @Test
    public void buttonWithHtmlTooltipTest() {
        buttonWithHtmlTooltip.is().visible();
        buttonWithHtmlTooltip.hover();
        buttonWithHtmlTooltip.tooltip().is().visible();
        buttonWithHtmlTooltip.tooltip().has().text(containsString("Tooltip with HTML"));
    }

    @Test
    public void hoverOrTouchTooltip() {
        hoverOrTouchButtonWithTooltip.is().visible();
        hoverOrTouchButtonWithTooltip.hover();
        hoverOrTouchButtonWithTooltip.tooltip().is().visible();
        hoverOrTouchButtonWithTooltip.tooltip().has().text("Add");
    }

    @Test
    public void hoverButtonTooltipTest() {
        hoverButtonWithTooltip.is().visible();
        hoverButtonWithTooltip.hover();
        hoverButtonWithTooltip.tooltip().is().visible();
        hoverButtonWithTooltip.tooltip().has().text("Add");
    }

    @Test
    public void clickButtonTooltipTest() {
        clickButtonWithTooltip.is().visible();
        clickButtonWithTooltip.click();
        clickButtonWithTooltip.tooltip().is().visible();
        clickButtonWithTooltip.tooltip().has().text("Add");
    }

    @Test
    public void disabledButtonWithTooltipTest() {
        disabledButtonWithTooltip.is().visible();
        disabledButtonWithTooltip.hover();
        disabledButtonWithTooltip.tooltip().is().visible();
        disabledButtonWithTooltip.tooltip().has().text("You don't have permission to do this");
    }
}
