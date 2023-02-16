package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.TooltipsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.tooltipsPage;
import static io.github.com.pages.TooltipsPage.buttonWithTooltip;
import static io.github.com.pages.TooltipsPage.cartIconWithTooltip;
import static io.github.com.pages.TooltipsPage.homeIconWithTooltip;
import static io.github.com.pages.TooltipsPage.textWithTooltip;
import static io.github.com.pages.TooltipsPage.toggleButtonWithTooltip;
import static io.github.com.pages.TooltipsPage.tooltip;
import static io.github.com.pages.TooltipsPage.coloredButtons;

public class TooltipsTests extends TestsInit {

    @BeforeClass
    public void before() {
        tooltipsPage.open();
        waitCondition(() -> tooltipsPage.isOpened());
        tooltipsPage.checkOpened();
    }

    @Test(description = "Test checks specific text of text tooltip")
    public void textTooltipsTest() {
        homeIconWithTooltip.is().displayed();
        buttonWithTooltip.hover();
        tooltip.is().displayed();
        tooltip.has().text("Tooltip for \"Button\"");
        homeIconWithTooltip.hover();
        tooltip.is().displayed();
        tooltip.has().text("Tooltip for \"mdi-home\"");
        textWithTooltip.hover();
        tooltip.is().displayed();
        tooltip.has().text("Tooltip for \"This text has a tooltip\"");
    }

    @Test(dataProvider = "colorsTooltipsTestDataProvider", dataProviderClass = TooltipsTestsDataProvider.class,
            description = "Test checks that tooltip has specific color")
    public void colorTooltipTest(int index, String color) {
        coloredButtons.get(index).hover();
        tooltip.is().displayed();
        tooltip.has().color(color);
    }

    @Test(description = "Test checks that programmatic tooltip appears correctly")
    public void programmaticTooltipTest() {
        toggleButtonWithTooltip.show();
        toggleButtonWithTooltip.hover();
        tooltip.is().hidden();
        toggleButtonWithTooltip.click();
        tooltip.is().displayed();
        tooltip.has().text("Programmatic tooltip");
        toggleButtonWithTooltip.click();
        tooltip.is().hidden();
        cartIconWithTooltip.hover();
        tooltip.is().displayed();
        tooltip.has().text("Programmatic tooltip");
        cartIconWithTooltip.click();
        tooltip.is().hidden();
    }
}
