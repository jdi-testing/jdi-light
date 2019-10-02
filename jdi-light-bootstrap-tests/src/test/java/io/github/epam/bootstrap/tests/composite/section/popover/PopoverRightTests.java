package io.github.epam.bootstrap.tests.composite.section.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertFalse;

/**
 * Created by Dmitrii Pavlov on 02.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PopoverRightTests extends TestsInit {

    private String dataContent = "Right popover is visible.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        popoverRight.hover();
        setLocators();
    }

    @Test
    public void isValidationTests() {
        popoverRight.popover.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn-secondary")
                .attr("type", "button")
                .attr("data-container", "body")
                .attr("data-toggle", "popover")
                .attr("data-placement", "right")
                .attr("data-content", dataContent)
                .text(is("Popover on right"));
    }

    @Test
    public void clickableTests() {
        popoverRight.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverRight.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-right show")
                .attr("role", "tooltip")
                .attr("x-placement", "right");
        popoverRight.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(dataContent));
        popoverTop.popover.click();
        popoverRight.popover.base().waitSec(1);
        popoverRight.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverRight
                .is()
                .enabled();
        popoverRight.popover.click();
        popoverRight.popover.base().waitSec(1);
        popoverRight.popover
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(isElementPresent());
    }

    private void setLocators() {
        popoverRight.popover.click();
        if (popoverRight.popover.hasAttribute("aria-describedby")) {
            String containerLocator = popoverRight.popover.base().get().getAttribute("aria-describedby");
            popoverRight.container.core().setLocator("#" + containerLocator);
            popoverRight.body.core().setLocator("#" + containerLocator + " .popover-body");
        } else {
            System.out.println("Popover isn't clickable or broken!");
        }
    }

    private boolean isElementPresent() {
        try {
            popoverRight.container.isEmpty();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
