package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledName;
import static io.github.com.pages.HtmlElementsPage.jdiTitle;
import static io.github.com.pages.HtmlElementsPage.name;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

/**
 * Test examples for Label with JDI Light asserts
 */
public class LabelExampleTests implements TestsInit {

    private String text = "JDI TESTING PLATFORM";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void labelTest() {
        name.label().is().text("Your name:");
        name.label().is().text(containsString("Your"));
        disabledName.label().is().text(equalToIgnoringCase("Surname:"));
    }

    @Test
    public void labelIsTest() {
        jdiTitle.is().enabled();
        jdiTitle.is().text(equalTo(text));
    }

    @Test
    public void labelAssertThatTest() {
        jdiTitle.assertThat().text(is(text));
    }

    @Test
    public void labelClickTest() {
        jdiTitle.click();
        validateAlert(containsString("JDI Title"));
    }

}
