package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.githubLink;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class LinkTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    String text = "Github JDI";

    //@TestSkipp
    public void getTextTest() {
        assertEquals(githubLink.getText(), text);
    }

    //@TestSkipp
    public void getValueTest() {
        assertEquals(githubLink.getValue(), text);
    }

    //@TestSkipp
    public void getRefTest() {
        assertEquals(githubLink.ref(), "https://github.com/jdi-testing");
    }

    //@TestSkipp
    public void getUrlTest() {
        assertEquals(githubLink.url().getPath(), "/jdi-testing");
    }

    //@TestSkipp
    public void getAltTest() {
        assertEquals(githubLink.alt(), "Github JDI Link");
    }

    //@TestSkipp
    public void clickTest() {
        githubLink.click();
        assertEquals(getUrl(), "https://github.com/jdi-testing");
        html5Page.open();
    }

    //@TestSkipp
    public void isValidationTest() {
        githubLink.is().text(is(text));
        githubLink.is().text(equalToIgnoringCase("Github jdi"));
        githubLink.is().enabled();
    }

    //@TestSkipp
    public void linkValidationTest() {
        githubLink.is().ref(containsString("github"));
        githubLink.is().alt(containsString("JDI"));
    }

    //@TestSkipp
    public void assertValidationTest() {
        githubLink.assertThat().text(is(text));
    }

    //@TestSkipp
    public void baseValidationTest() {
        baseValidation(githubLink);
    }
}
