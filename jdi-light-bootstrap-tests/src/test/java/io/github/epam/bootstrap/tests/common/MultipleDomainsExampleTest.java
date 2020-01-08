package io.github.epam.bootstrap.tests.common;

import io.github.epam.MultipleDomainsTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.DocsSite.docPage;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.simpleAlert;
import static io.github.com.pages.DocsPage.facebookLink;
import static io.github.epam.states.States.shouldBeLoggedIn;

// QUESTIONS: What is this about?
public class MultipleDomainsExampleTest extends MultipleDomainsTestInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void simpleVisibilityTest() {
        bsPage.open();
        simpleAlert.is().displayed();
        simpleAlert.is().enabled();
        docPage.open();
        facebookLink.is().displayed();
    }
}
