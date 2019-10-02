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

public class PopoverLeftTests extends TestsInit {

    private String dataContent = "Left popover is visible.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        popoverLeft.hover();
    }

    @Test
    public void isValidationTests() {
        popoverLeft.popover.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn-secondary")
                .attr("type", "button")
                .attr("data-container", "body")
                .attr("data-toggle", "popover")
                .attr("data-placement", "left")
                .attr("data-content", dataContent)
                .text(is("Popover on left"));
    }

    @Test
    public void clickableTests() {
        popoverLeft.popover.click();
        popoverLeft.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverLeft.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-left show")
                .attr("role", "tooltip")
                .attr("x-placement", "left");
        popoverLeft.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(dataContent));
        popoverRight.popover.click();
        popoverLeft.popover.base().waitSec(1);
        popoverLeft.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverLeft.container
                .is()
                .enabled();
        popoverLeft.popover.click();
        popoverLeft.popover.base().waitSec(1);
        popoverLeft.popover
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(isElementPresent());
    }

    private boolean isElementPresent() {
        try {
            popoverLeft.container.isEmpty();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
