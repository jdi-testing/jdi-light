package io.github.epam.bootstrap.tests.composite.section.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.popoverDismissible;
import static io.github.com.pages.BootstrapPage.popoverRight;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertFalse;

/**
 * Created by Dmitrii Pavlov on 02.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PopoverDismissibleTests extends TestsInit {

    private String dataContent = "And here's some amazing content. It's very engaging. Right?";
    private String dataTitle = "Dismissible popover";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        popoverDismissible.hover();
        setLocators();
    }

    @Test
    public void isValidationTests() {
        popoverDismissible.popover.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-lg btn-danger btn-block mb-3")
                .attr("data-trigger", "focus")
                .attr("data-toggle", "popover")
                .attr("data-original-title", dataTitle)
                .attr("data-content", dataContent)
                .attr("tabindex", "0")
                .text(is("Dismissible popover"));
    }

    @Test
    public void clickableTests() {
        popoverDismissible.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverDismissible.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-right show")
                .attr("role", "tooltip")
                .attr("x-placement", "right");
        popoverDismissible.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(dataContent));
        popoverDismissible.header
                .is()
                .enabled()
                .core()
                .hasClass("popover-header")
                .text(is(containsStringIgnoringCase(dataTitle)));
        popoverDismissible.popover.click();
        popoverDismissible.popover.base().waitSec(1);
        popoverDismissible.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverDismissible.container
                .is()
                .enabled();
        popoverRight.popover.click();
        popoverDismissible.popover.base().waitSec(1);
        popoverDismissible.popover
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(isElementPresent());
    }

    private void setLocators() {
        popoverDismissible.popover.click();
        if (popoverDismissible.popover.hasAttribute("aria-describedby")) {
            String containerLocator = popoverDismissible.popover.base().get().getAttribute("aria-describedby");
            popoverDismissible.container.core().setLocator("#" + containerLocator);
            popoverDismissible.header.core().setLocator("#" + containerLocator + " h3");
            popoverDismissible.body.core().setLocator("#" + containerLocator + " .popover-body");
        } else {
            System.out.println("Popover isn't clickable or broken!");
        }
    }

    private boolean isElementPresent() {
        try {
            popoverDismissible.container.isEnabled();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
