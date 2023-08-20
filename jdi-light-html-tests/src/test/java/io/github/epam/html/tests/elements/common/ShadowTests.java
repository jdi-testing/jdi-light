package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.com.pages.HtmlElementsPage.shadowContainer;

public class ShadowTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.open();
    }

    @Test
    public void shadowElementTest() {
        shadowContainer.show();
        shadowContainer.title.has().text("Inside Shadow DOM");
        shadowContainer.shadowText.has().text("Text inside Shadow DOM");
        shadowContainer.shadowBtn.click();
        shadowContainer.shadowText.has().text("Button was clicked");
    }
}
