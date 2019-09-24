package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.badgeSecondary;
import static io.github.com.pages.BootstrapPage.badgeSuccess;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BadgeTests extends TestsInit {
    private String badgeSecondaryText = "BADGE";
    private String badgeSuccessText = "Github JDI";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTextTest() {
        assertEquals(badgeSecondary.getText(), badgeSecondaryText);
        assertEquals(badgeSecondary.getValue(), badgeSecondaryText);
        assertEquals(badgeSuccess.getText(), badgeSuccessText);
        assertEquals(badgeSuccess.getValue(), badgeSuccessText);
    }

    @Test
    public void simpleVisibilityTest() {
        assertTrue(badgeSecondary.isDisplayed());
        assertTrue(badgeSuccess.isDisplayed());
    }

    @Test
    public void isValidationTest() {
        badgeSecondary.assertThat().displayed()
                .and()
                .core()
                .cssClass("badge badge-secondary")
                .attr("id", "badge-secondary")
                .tag(is("span"));

        badgeSuccess.assertThat().displayed()
                .and()
                .text(is(badgeSuccessText))
                .text(containsString(badgeSuccessText))
                .core()
                .cssClass("badge badge-success")
                .attr("id", "badge-success")
                .attr("alt", "Github JDI Link")
                .tag(is("a"));
    }
}