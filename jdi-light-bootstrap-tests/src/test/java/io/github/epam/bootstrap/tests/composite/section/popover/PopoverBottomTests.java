package io.github.epam.bootstrap.tests.composite.section.popover;

import com.epam.jdi.light.ui.bootstrap.elements.common.Popover;
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

public class PopoverBottomTests extends TestsInit {

    private String dataContent = "Bottom popover is visible.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        popoverBottom.hover();
        setLocators();
    }

    @Test
    public void isValidationTests() {
        popoverBottom.popover.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn-secondary")
                .attr("type", "button")
                .attr("data-container", "body")
                .attr("data-toggle", "popover")
                .attr("data-placement", "bottom")
                .attr("data-content", dataContent)
                .text(is("Popover on bottom"));
    }

    @Test
    public void clickableTests() {
        popoverBottom.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverBottom.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-bottom show")
                .attr("role", "tooltip")
                .attr("x-placement", "bottom");
        popoverBottom.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(dataContent));
        popoverRight.popover.click();
        popoverBottom.popover.base().waitSec(1);
        popoverBottom.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverBottom.container
                .is()
                .enabled();
        popoverBottom.popover.click();
        popoverBottom.popover.base().waitSec(1);
        popoverBottom.popover
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(isElementPresent());
    }

    private void setLocators() {
        popoverBottom.popover.click();
        if (popoverBottom.popover.hasAttribute("aria-describedby")) {
            String containerLocator = popoverBottom.popover.base().get().getAttribute("aria-describedby");
            popoverBottom.container.core().setLocator("#" + containerLocator);
            popoverBottom.body.core().setLocator("#" + containerLocator + " .popover-body");
        } else {
            System.out.println("Popover isn't clickable or broken!");
        }
    }

    private boolean isElementPresent() {
        try {
            popoverBottom.container.isEmpty();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
