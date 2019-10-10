package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formCustomStyles;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class CustomStyleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void fillTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CONTACT);
        formCustomStyles.submit();
    }

    @Test
    public void fillTest2() {
        formCustomStyles.add(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CONTACT);
    }
}
