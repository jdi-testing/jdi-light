package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.composite.WebPage.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class LinkTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    String text = "Github JDI";

    //TODO Performance issue
    @Test
    public void getTextTest() {
        assertEquals(githubLink.getText(), text);
    }

    //TODO Performance issue
    @Test
    public void getValueTest() {
        assertEquals(githubLink.getValue(), text);
    }

    //TODO Performance issue
    @Test
    public void getRefTest() {
        assertEquals(githubLink.ref(), "https://github.com/jdi-testing");
    }

    //TODO Performance issue
    @Test
    public void getUrlTest() {
        assertEquals(githubLink.url().getPath(), "/jdi-testing");
    }

    //TODO Performance issue
    @Test
    public void getAltTest() {
        assertEquals(githubLink.alt(), "Github JDI Link");
    }

    //TODO Performance issue
    @Test
    public void clickTest() {
        githubLink.click();
        assertEquals(getUrl(), "https://github.com/jdi-testing");
        html5Page.open();
    }

    //TODO Performance issue
    @Test
    public void isValidationTest() {
        githubLink.is().text(is(text));
        githubLink.is().text(equalToIgnoringCase("Github jdi"));
        githubLink.is().enabled();
    }

    //TODO Performance issue
    @Test
    public void linkValidationTest() {
        githubLink.is().ref(containsString("github"));
        githubLink.is().alt(containsString("JDI"));
    }

    //TODO Performance issue
    @Test
    public void assertValidationTest() {
        githubLink.assertThat().text(is(text));
    }

    //TODO Performance issue
    @Test
    public void baseValidationTest() {
        baseValidation(githubLink);
    }
}
