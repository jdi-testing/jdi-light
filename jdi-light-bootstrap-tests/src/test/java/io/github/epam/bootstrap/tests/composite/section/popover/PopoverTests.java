package io.github.epam.bootstrap.tests.composite.section.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.popover;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertFalse;

/**
 * Created by Dmitrii Pavlov on 04.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PopoverTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {"#popover-top", "top", "Top popover is visible.", "", "Popover on top"},
                {"#popover-right", "right", "Right popover is visible.", "", "Popover on right"},
                {"#popover-bottom", "bottom", "Bottom popover is visible.", "", "Popover on bottom"},
                {"#popover-left", "left", "Left popover is visible.", "", "Popover on left"},
                {"#popover-title", "right", "And here's some amazing content. It's very engaging. Right?", "Popover title", "Click to toggle popover"},
                {"#popover-disabled", "right", "Disabled popover", "", "Disabled button"},
        };
    }

    @Test(dataProvider = "listData")
    public void isValidationTests(String locator, String __, String popoverBody, String popoverHeader, String buttonText) {
        popover.getPopover(locator);
        popover.popoverButton.is()
                .displayed()
                .enabled()
                .core()
                .attr("data-toggle", "popover")
                .attr("data-content", popoverBody)
                .attr("data-original-title", popoverHeader)
                .text(is(buttonText));
        popover.popoverButton.click();
    }

    @Test(dataProvider = "listData")
    public void clickableTests(String locator, String placement, String popoverBody, String popoverHeader, String __) {
        popover.getPopover(locator);
        popover.popoverButton
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popover.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-" + placement + " show")
                .attr("role", "tooltip")
                .attr("x-placement", placement);
        popover.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(popoverBody));
        popover.header
                .is()
                .core()
                .hasClass("popover-header");
        popover.container.click();
        popover.popoverButton.base().waitSec(1);
        popover.popoverButton
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popover.container
                .is()
                .enabled();
        popover.popoverButton.click();
        popover.popoverButton.base().waitSec(1);
        popover.popoverButton
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(popover.container.isDisplayed());
    }

    @Test()
    public void titleIsValidationTest() {
        popover.getPopover("#popover-title");
        popover.header
                .is()
                .core()
                .hasClass("popover-header")
                .text(is(containsString("Popover title".toUpperCase())));
        popover.popoverButton.click();
    }

    @Test()
    public void dismissibleClickableTests() {
        popover.getPopover("#popover-dismissible");
        popover.popoverButton
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("aria-describedby", containsString("popover"))
                .attr("data-trigger", "focus")
                .attr("data-toggle", "popover")
                .attr("role", "button")
                .attr("tabindex", "0")
                .attr("data-content", "And here's some amazing content. It's very engaging. Right?")
                .attr("data-original-title", "Dismissible popover")
                .text(is("Dismissible popover"))
                .tag(is("a"));
        popover.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-right show")
                .attr("role", "tooltip")
                .attr("x-placement", "right");
        popover.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is("And here's some amazing content. It's very engaging. Right?"));
        popover.header
                .is()
                .core()
                .hasClass("popover-header")
                .text(is("Dismissible popover".toUpperCase()));
        popover.popoverButton.click();
        popover.popoverButton.base().waitSec(1);
        popover.popoverButton
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popover.container
                .is()
                .enabled();
        popover.container.click();
        popover.popoverButton.base().waitSec(1);
        popover.popoverButton
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(popover.container.isDisplayed());
    }
}
