package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.tooltipPage;
import static io.github.com.pages.displaydata.TooltipPage.clickButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.customizableTooltipsButton;
import static io.github.com.pages.displaydata.TooltipPage.disabledButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.hoverButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.hoverOrTouchButtonWithTooltip;
import static io.github.com.pages.displaydata.TooltipPage.simpleTooltipsButton;
import io.github.epam.TestsInit;
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
        simpleTooltipsButton.get(number).hover();
        simpleTooltipsButton.get(number).tooltip().is().visible();
        simpleTooltipsButton.get(number).tooltip().has().text(text);
    }

    @Test(dataProvider = "customizableTooltipsTestData")
    public void customizableTooltipsTest(int number, String text) {
        customizableTooltipsButton.get(number).hover();
        customizableTooltipsButton.get(number).tooltip().is().visible();
        customizableTooltipsButton.get(number).tooltip().has().text(containsString(text));
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

