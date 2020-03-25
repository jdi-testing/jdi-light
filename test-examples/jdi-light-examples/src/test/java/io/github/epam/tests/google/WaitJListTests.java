package io.github.epam.tests.google;

import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.Header.*;
import static io.github.com.pages.SearchPage.*;
import static io.github.epam.tests.recommended.steps.Preconditions.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitJListTests extends StaticTestsInit {
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
        TIMEOUTS.element.setUp(2);
        try {
            jsearchTitle.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ignored) { }
        finally {
            TIMEOUTS.element.drop();
        }
        logger.info("Done");
    }
    @Test
    public void sizeTest() {
        assertEquals(jsearchTitle.size(), 6);
        jsearchTitle.is().size(equalTo(8));
    }
    @Test
    public void sizeNotEmptyTest() {
        jsearchTitle.is().size(greaterThan(7));
    }

}
