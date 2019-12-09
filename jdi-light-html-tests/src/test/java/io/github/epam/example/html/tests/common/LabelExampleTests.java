package io.github.epam.example.html.tests.common;

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


public class LabelExampleTests extends TestsInit {

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
        jdiTitle.is().enabled();
        jdiTitle.is().text(equalTo(text));
        jdiTitle.assertThat().text(is(text));
        jdiTitle.click();
        validateAlert(containsString("JDI Title"));
    }

}
