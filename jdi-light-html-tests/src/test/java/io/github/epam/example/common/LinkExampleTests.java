package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.githubLink;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;

/**
 * Test examples for Link with JDI Light asserts
 */

public class LinkExampleTests implements TestsInit {
    private static final String EXPECTED_TEXT = "Github JDI",
            PART_OF_EXPECTED_TEXT = "JDI",
            EXPECTED_ALT = "Github JDI Link",
            EXPECTED_ALT_REGEX = "Git.* JE*DI Link",
            PART_OF_EXPECTED_ALT = "Git",
            EXPECTED_URL = "https://github.com/jdi-testing",
            PART_OF_EXPECTED_URL = "https://github.com/",
            EXPECTED_URL_REGEX = "^((?:https?:\\/\\/)?[^./]+(?:\\.[^./]+)+(?:\\/.*)?)$";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void linkTest() {
        githubLink.assertThat()
                .displayed()
                .and()
                .enabled()
                .and()
                .core()
                .css("font-size", is("14px"));
    }

    @Test
    public void linkTextTest() {
        githubLink.is().text(EXPECTED_TEXT);
        githubLink.is().text(equalTo(EXPECTED_TEXT));
        githubLink.is().text(containsString(PART_OF_EXPECTED_TEXT));
    }

    @Test
    public void linkRefTest() {
        githubLink.is().ref(EXPECTED_URL);
        githubLink.is().ref(equalTo(EXPECTED_URL));
        githubLink.is().ref(containsString(PART_OF_EXPECTED_URL));
        githubLink.is().ref(matchesPattern(EXPECTED_URL_REGEX));
    }

    @Test
    public void linkAltTest() {
        githubLink.is().alt(equalTo(EXPECTED_ALT));
        githubLink.is().alt(matchesPattern(EXPECTED_ALT_REGEX));
        githubLink.is().alt(containsString(PART_OF_EXPECTED_ALT));
        githubLink.is().alt(EXPECTED_ALT);
    }
}
