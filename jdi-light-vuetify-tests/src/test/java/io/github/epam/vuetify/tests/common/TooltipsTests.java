package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tooltipsPage;
import static io.github.com.pages.TooltipsPage.buttonWithTooltip;
import static io.github.com.pages.TooltipsPage.cartIconWithTooltip;
import static io.github.com.pages.TooltipsPage.homeIconWithTooltip;
import static io.github.com.pages.TooltipsPage.textWithTooltip;
import static io.github.com.pages.TooltipsPage.toggleButtonWithTooltip;
import static io.github.com.pages.TooltipsPage.tooltip;

public class TooltipsTests extends TestsInit {

    @BeforeClass
    public void before() {
        tooltipsPage.open();
    }

    @Test
    public void tooltipsTests() {
        homeIconWithTooltip.is().displayed();
        buttonWithTooltip.hover();
        tooltip.is().displayed();
        tooltip.has().text("Tooltip");
        homeIconWithTooltip.hover();
        tooltip.is().displayed();
        tooltip.has().text("Tooltip");
        textWithTooltip.hover();
        tooltip.is().displayed();
        tooltip.has().text("Tooltip");
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
