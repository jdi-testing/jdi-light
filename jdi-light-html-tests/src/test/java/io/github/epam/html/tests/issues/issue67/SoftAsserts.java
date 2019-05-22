package io.github.epam.html.tests.issues.issue67;

import com.epam.jdi.light.asserts.IsAssert;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;


public class SoftAsserts extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void softAssertTest() {
        redButton.is().hidden()
                .displayed()
                .disabled()
                .getResults();
    }
}
