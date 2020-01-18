package io.github.epam.html.tests.site;

import io.github.epam.MultipleDomainsTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.DocsSite.docPage;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.DocsPage.documentation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class MultipleDomainsExampleTest implements MultipleDomainsTestInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
    }

    @Test
    public void simpleVisibilityTest() {
        contactFormPage.open();
        main.contactForm.is().displayed();
        docPage.open();
        documentation.is().displayed();
    }
}
