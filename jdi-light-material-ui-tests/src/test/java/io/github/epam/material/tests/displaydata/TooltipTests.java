package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Tooltip;
import static io.github.com.StaticSite.tooltipPage;
import io.github.com.custom.TooltipButton;
import static io.github.com.pages.displaydata.TooltipPage.clickButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.customizableTooltipsButton;
import static io.github.com.pages.displaydata.TooltipPage.disabledButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.hoverButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.hoverOrTouchButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.simpleTooltipsButton;
import io.github.epam.TestsInit;
import java.awt.Button;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "simpleTooltipsTestData")
    public void simpleTooltipsTest(int number, String text) {
        checkTooltip(simpleTooltipsButton.get(number), text);
    }

    @Test(dataProvider = "customizableTooltipsTestData")
    public void customizableTooltipsTest(int number, String text) {
        checkTooltip(customizableTooltipsButton.get(number), text);
    }

    @Test
    public void hoverOrTouchTooltip() {
        checkTooltip(hoverOrTouchButtonWithTooltip, "Add");
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

    @Test
    public void disabledButtonWithTooltipTest() {
        checkTooltip(disabledButtonWithTooltip, "You don't have permission to do this");
    }

    private static void checkTooltip(TooltipButton tooltipButton, String expectedText) {
        tooltipButton.hover();
        tooltipButton.tooltip().is().visible();
        tooltipButton.tooltip().has().text(containsString(expectedText));
    }

    @DataProvider
    public Object[][] simpleTooltipsTestData() {
        return new Object[][]{
                {1, "Delete"}, {2, "Add"}, {3, "Add"}
        };
    }

    @DataProvider
    public Object[][] customizableTooltipsTestData() {
        return new Object[][]{
                {1, "Add"}, {2, "Add"}, {3, "Tooltip with HTML"}
        };
    }
}

