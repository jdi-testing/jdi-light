package io.github.epam.html.tests.elements.complex.list;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.Header.*;
import static io.github.com.pages.SearchPage.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitJListTests implements TestsInit {

    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        shouldBeLoggedIn();
        search("jdi");
    }

    @Test
    public void notEmptyTest() {
        jsearchTitle.is().notEmpty();
    }

    @Test
    public void notEmpty2Test() {
        jsearchTitle.assertThat(not(empty()));
    }

    @Test
    public void emptyTest() {
        jsearchTitle.waitFor(2).notEmpty();
    }

    @Test
    public void sizeTest() {
        assertEquals(jsearchTitle.size(), 6);
        // FLAKY
        jsearchTitle.waitFor(10).size(equalTo(8));
    }

    @Test
    public void sizeNotEmptyTest() {
        // FLAKY
        jsearchTitle.waitFor(10).size(greaterThan(7));
    }

}
