package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.githubLink;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageLinkTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
    }
    String text = "Github JDI";

    @Test
    public void isValidationTest() {
        githubLink.is().text(is(text));
        githubLink.is().text(equalToIgnoringCase("Github jdi"));
        githubLink.is().enabled();
    }

    @Test
    public void linkValidationTest() {
        githubLink.is().ref(containsString("github"));
        githubLink.is().alt(containsString("JDI"));
    }

    @Test
    public void assertValidationTest() {
        githubLink.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(githubLink);
    }
}
