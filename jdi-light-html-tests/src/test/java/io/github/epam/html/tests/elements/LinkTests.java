package io.github.epam.html.tests.elements;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.githubLink;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class LinkTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
    }
    String text = "Github JDI";

    @Test
    public void getTextTest() {
        assertEquals(githubLink.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(githubLink.getValue(), text);
    }

    @Test
    public void getRefTest() {
        assertEquals(githubLink.ref(), "https://github.com/jdi-testing");
    }

    @Test
    public void getUrlTest() {
        assertEquals(githubLink.url().getPath(), "/jdi-testing");
    }

    @Test
    public void getAltTest() {
        assertEquals(githubLink.alt(), "Github JDI Link");
    }

    @Test
    public void clickTest() {
        githubLink.click();
        assertEquals(getUrl(), "https://github.com/jdi-testing");
        htmlElementsPage.open();
    }

    @Test
    public void isValidationTest() {
        githubLink.is().text(is(text));
        githubLink.is().text(equalToIgnoringCase("Github jdi"));
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
