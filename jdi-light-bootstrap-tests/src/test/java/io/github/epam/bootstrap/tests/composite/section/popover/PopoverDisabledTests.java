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

public class PopoverDisabledTests extends TestsInit {

    private String dataContent = "Disabled popover";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        popoverDisabled.hover();
        setLocators();
    }

    @Test
    public void isValidationTests() {
        popoverDisabled.popover.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("d-inline-block")
                .attr("data-toggle", "popover")
                .attr("data-content", dataContent)
                .text(is("Disabled button"))
                .tag(is("span"));
    }

    @Test
    public void clickableTests() {
        popoverDisabled.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverDisabled.container
                .is()
                .enabled()
                .core()
                .hasClass("popover fade bs-popover-right show")
                .attr("role", "tooltip")
                .attr("x-placement", "right");
        popoverDisabled.body
                .is()
                .enabled()
                .core()
                .hasClass("popover-body")
                .text(is(dataContent));
        popoverRight.popover.click();
        popoverDisabled.popover.base().waitSec(1);
        popoverDisabled.popover
                .is()
                .core()
                .attr("aria-describedby", containsString("popover"));
        popoverDisabled
                .is()
                .enabled();
        popoverDisabled.popover.click();
        popoverDisabled.popover.base().waitSec(1);
        popoverDisabled.popover
                .is()
                .core()
                .attr("aria-describedby", "");
        assertFalse(isElementPresent());
    }

    private void setLocators() {
        popoverDisabled.popover.click();
        if (popoverDisabled.popover.hasAttribute("aria-describedby")) {
            String containerLocator = popoverDisabled.popover.base().get().getAttribute("aria-describedby");
            popoverDisabled.container.core().setLocator("#" + containerLocator);
            popoverDisabled.body.core().setLocator("#" + containerLocator + " .popover-body");
        } else {
            System.out.println("Popover isn't clickable or broken!");
        }
    }

    private boolean isElementPresent() {
        try {
            popoverDisabled.container.isEmpty();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
