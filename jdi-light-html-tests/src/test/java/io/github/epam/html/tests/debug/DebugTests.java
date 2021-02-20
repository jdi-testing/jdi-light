package io.github.epam.html.tests.debug;

import io.github.epam.TestsInit;
import io.github.epam.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.ghostButton;
import static io.github.com.pages.HtmlElementsPage.suspendButton;
import static io.github.epam.html.tests.elements.BaseValidations.durationImmediately;
import static io.github.epam.html.tests.elements.BaseValidations.durationMoreThan;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
//@Listeners(TestNGListener.class)
public class DebugTests {//implements TestsInit {
//    @BeforeMethod
//    public void before() {
//        shouldBeLoggedIn();
//        html5Page.shouldBeOpened();
//        refresh();
//    }
//
//    @Test
//    public void vanishHiddenButtonTest() {
//        durationImmediately(() -> suspendButton.is().hidden());
//        durationMoreThan(5, () -> ghostButton.is().hidden());
//    }
}
