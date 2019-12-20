package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.progress;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ProgressExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void labelTextTest() {
        progress.label().is().text("File progress");
    }

    @Test
    public void valueTest() {
        progress.is().volume(70);
        progress.is().volume(greaterThanOrEqualTo(10));
        progress.is().volume(lessThanOrEqualTo(100));
    }

    @Test
    public void maxTest() {
        progress.is().maxVolume(100);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(progress);
    }




}
