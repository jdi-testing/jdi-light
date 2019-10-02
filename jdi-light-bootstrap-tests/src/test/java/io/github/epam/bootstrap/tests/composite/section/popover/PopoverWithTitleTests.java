package io.github.epam.bootstrap.tests.composite.section.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.popoverRight;
import static io.github.com.pages.BootstrapPage.popoverWithTitle;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertFalse;

/**
 * Created by Dmitrii Pavlov on 02.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PopoverWithTitleTests extends TestsInit {

    private String dataContent = "And here's some amazing content. It's very engaging. Right?";
    private String dataTitle = "Popover title";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        popoverWithTitle.hover();
        setLocators();
    }

    @Test
    public void isValidationTests() {
        popoverWithTitle.popover.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-lg btn-danger btn-block mb-3")
                .attr("type", "button")
                .attr("data-toggle", "popover")
                .attr("data-original-title", dataTitle)
                .attr("data-content", dataContent)
                .text(is("Click to toggle popover"));
    }

    @Test
    public void clickableTests() {
        popoverWithTitle.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverWithTitle.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-right show")
                .attr("role", "tooltip")
                .attr("x-placement", "right");
        popoverWithTitle.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(dataContent));
        popoverWithTitle.header
                .is()
                .enabled()
                .core()
                .hasClass("popover-header")
                .text(is(containsStringIgnoringCase(dataTitle)));
        popoverRight.popover.click();
        popoverWithTitle.popover.base().waitSec(1);
        popoverWithTitle.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverWithTitle.container
                .is()
                .enabled();
        popoverWithTitle.popover.click();
        popoverWithTitle.popover.base().waitSec(1);
        popoverWithTitle.popover
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(isElementPresent());
    }

    private void setLocators() {
        popoverWithTitle.popover.click();
        if (popoverWithTitle.popover.hasAttribute("aria-describedby")) {
            String containerLocator = popoverWithTitle.popover.base().get().getAttribute("aria-describedby");
            popoverWithTitle.container.core().setLocator("#" + containerLocator);
            popoverWithTitle.header.core().setLocator("#" + containerLocator + " h3");
            popoverWithTitle.body.core().setLocator("#" + containerLocator + " .popover-body");
        } else {
            System.out.println("Popover isn't clickable or broken!");
        }
    }

    private boolean isElementPresent() {
        try {
            popoverWithTitle.container.isEmpty();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
