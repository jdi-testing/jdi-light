package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.ui.bootstrap.elements.common.Tooltip;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.tooltipOnTopButton;
import static io.github.com.pages.BootstrapPage.tooltipOnBottomButton;
import static io.github.com.pages.BootstrapPage.tooltipOnLeftButton;
import static io.github.com.pages.BootstrapPage.tooltipOnRightButton;
import static io.github.com.pages.BootstrapPage.tooltipWithHTML;
import static io.github.com.pages.BootstrapPage.tooltipOnDisabledButton;
import static io.github.com.pages.BootstrapPage.wrapperForDisabledButton;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertFalse;

public class TooltipTests extends TestsInit {

    private static String textOnBottomTooltip = "Tooltip on bottom";
    private static String textOnTopTooltip = "Tooltip on top";
    private static String textOnRightTooltip = "Tooltip on right";
    private static String textOnLeftTooltip = "Tooltip on left";
    private static String textOnHTMLTooltip = "<em>Tooltip</em> <u>with</u> <b>HTML</b>";
    private static String textOnDisabledButton = "Disabled tooltip";

    private static String bottom = "bottom";
    private static String top = "top";
    private static String left = "left";
    private static String right = "right";

    private static String topButtonText = "Tooltip on top";
    private static String bottomButtonText = "Tooltip on bottom";
    private static String rightButtonText = "Tooltip on right";
    private static String leftButtonText = "Tooltip on left";
    private static String htmlButtonText = "Tooltip with HTML";
    private static String disabledButtonText = "Disabled button";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider(name = "TooltipsPlacements")
    public static Object[][] tooltipsPlacement() {
        return new Object[][]{
                {tooltipOnTopButton, top},
                {tooltipOnBottomButton, bottom},
                {tooltipOnLeftButton, left},
                {tooltipOnRightButton, right}
        };
    }

    @DataProvider(name = "Tooltips")
    public static Object[][] tooltips() {
        return new Object[][]{
                {tooltipOnTopButton, textOnTopTooltip},
                {tooltipOnBottomButton, textOnBottomTooltip},
                {tooltipOnLeftButton, textOnLeftTooltip},
                {tooltipOnRightButton, textOnRightTooltip},
                {tooltipWithHTML, textOnHTMLTooltip},
                {wrapperForDisabledButton, textOnDisabledButton}
        };
    }

    @DataProvider(name = "Buttons")
    public static Object[][] buttonsText() {
        return new Object[][]{
                {tooltipOnTopButton, topButtonText},
                {tooltipOnBottomButton, bottomButtonText},
                {tooltipOnLeftButton, leftButtonText},
                {tooltipOnRightButton, rightButtonText},
                {tooltipOnBottomButton, bottomButtonText},
                {tooltipWithHTML, htmlButtonText}
        };
    }

    @Test(dataProvider = "Tooltips")
    public void getTooltipTextTests(Tooltip tooltip, String tooltipText) {
        assertEquals(tooltip.getTooltipText(), tooltipText);
    }

    @Test(dataProvider = "Tooltips")
    public void tooltipIsInvisibleTests(Tooltip tooltip, String __) {
        tooltip.is().hidden();
    }

    @Test(dataProvider = "Tooltips")
    public void tooltipIsVisibleByHoverTests(Tooltip tooltip, String __) {
        tooltip.core().hover();
        tooltip.assertThat().isVisible();
    }

    @Test(dataProvider = "Tooltips")
    public void tooltipIsVisibleByFocusTests(Tooltip tooltip, String __) {
        tooltip.core().focus();
        tooltip.is().isVisible();
    }

    @Test(dataProvider = "Tooltips")
    public void tooltipIsVisibleByClickTests(Tooltip tooltip, String __) {
        tooltip.click();
        tooltip.assertThat().isVisible();
    }

    @Test(dataProvider = "TooltipsPlacements")
    public void tooltipPlacementTests(Tooltip tooltip, String placement) {
        assertEquals(tooltip.getTooltipPlacement(), placement);
    }

    @Test
    public void tooltipWithHtmlTest() {
        assertTrue(tooltipWithHTML.isTooltipWithHTML());
    }

    @Test(dataProvider = "TooltipsPlacements")
    public void tooltipWithoutHtmlTest(Tooltip tooltip, String __) {
        assertFalse(tooltip.isTooltipWithHTML());
    }

    @Test
    public void tooltipOnDisabledButtonIsInvisibleByHoverTest() {
        tooltipOnDisabledButton.core().hover();
        tooltipOnDisabledButton.is().hidden();
    }

    @Test
    public void tooltipOnDisabledButtonIsInvisibleByFocusTest() {
        tooltipOnBottomButton.core().focus();
        tooltipOnDisabledButton.is().hidden();
    }

    @Test
    public void isValidationTestForDisabledButton() {
        tooltipOnDisabledButton.is()
                .displayed()
                .text(disabledButtonText)
                .disabled()
                .core()
                .cssClass("btn btn-info btn-block")
                .tag(is("button"));
        try {
            tooltipOnDisabledButton.click();
            fail("Disabled button should not work, but work");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                    containsString("Can't perform click. Element is disabled"));
        }
    }

    @Test(dataProvider = "Buttons")
    public void isValidationTest(Tooltip tooltip, String buttonText) {
        tooltip.is()
                .displayed()
                .enabled()
                .text(buttonText)
                .core()
                .cssClass("btn btn-info btn-block")
                .attr("data-toggle", "tooltip")
                .tag(is("button"));
    }
}
