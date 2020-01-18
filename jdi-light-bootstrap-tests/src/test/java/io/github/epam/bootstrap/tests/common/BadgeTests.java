package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.badge;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class BadgeTests extends TestsInit {
    private String text = "Unread Messages 9";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        badge.show();
    }

    @Test
    public void getTextTest() {
        assertEquals(badge.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(badge.getValue(), text);
    }

    @Test
    public void clickTest() {
        badge.click();
        validateAlert(is("Button with badge"));
    }

    @Test
    public void isValidationTest() {
        badge.is().displayed().and().enabled().and().text(is(text));
        badge.is().text(containsString("Messages"));
        assertThat(badge.core().css("font-size"), is("16px"));
        badge.assertThat().displayed()
                .and().text(is(text))
                .core()
                .css("font-size", is("16px"))
                .cssClass("btn btn-primary")
                .attr("type", "button")
                .tag(is("button"));
    }

    @Test
    public void assertValidationTest() {
        badge.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(badge);
    }
}
