package io.github.epam.bootstrap.tests.composite.section.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.popoverTop;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitrii Pavlov on 26.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PopoverTopTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
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
                .attr("data-content", "Top popover is visible.")
                .text(is("Popover on top"));
    }

    @Test
    public void clickableTests() {
        popoverTop.click();
        popoverTop.is().core().attr("aria-describedby", containsString("popover"));

    }
}
