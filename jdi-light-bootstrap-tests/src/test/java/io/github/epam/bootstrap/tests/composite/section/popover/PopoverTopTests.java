package io.github.epam.bootstrap.tests.composite.section.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.popoverRight;
import static io.github.com.pages.BootstrapPage.popoverTop;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertFalse;

/**
 * Created by Dmitrii Pavlov on 02.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PopoverTopTests extends TestsInit {

    private String dataContent = "Top popover is visible.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        popoverTop.hover();
        setLocators();
    }

    @Test
    public void isValidationTests() {
        popoverTop.popover.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn-secondary")
                .attr("type", "button")
                .attr("data-container", "body")
                .attr("data-toggle", "popover")
                .attr("data-placement", "top")
                .attr("data-content", dataContent)
                .text(is("Popover on top"));
    }

    @Test
    public void clickableTests() {
        popoverTop.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverTop.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-top show")
                .attr("role", "tooltip")
                .attr("x-placement", "top");
        popoverTop.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(dataContent));
        popoverRight.popover.click();
        popoverTop.popover.base().waitSec(1);
        popoverTop.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverTop.container
                .is()
                .enabled();
        popoverTop.popover.click();
        popoverTop.popover.base().waitSec(1);
        popoverTop.popover
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(isElementPresent());
    }

    private void setLocators() {
        popoverTop.popover.click();
        if (popoverTop.popover.hasAttribute("aria-describedby")) {
            String containerLocator = popoverTop.popover.base().get().getAttribute("aria-describedby");
            popoverTop.container.core().setLocator("#" + containerLocator);
            popoverTop.body.core().setLocator("#" + containerLocator + " .popover-body");
        } else {
            System.out.println("Popover isn't clickable or broken!");
        }
    }

    private boolean isElementPresent() {
        try {
            popoverTop.container.isEnabled();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
