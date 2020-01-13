package io.github.epam.example.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.common.FormFilters.ALL;
import static io.github.com.entities.Users.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.Users.DEFAULT_CONTACT;
import static io.github.com.entities.Users.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.epam.html.tests.site.steps.States.shouldContactPageBeOpenedAndRefreshed;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormExampleTests implements TestsInit {

//    @Test
//    public void loginWithUserTest() {
//        shouldBeLoggedOut();
//        loginForm.shouldBeOpened();
//        loginForm.login(DEFAULT_USER);
//        homePage.checkOpened();
//    }
//
//    @Test
//    public void loginWithUserToLightLocatorFormTest() {
//        shouldBeLoggedOut();
//        refresh();
//        userIcon.click();
//        loginAs("#login-form", DEFAULT_USER);
//        homePage.checkOpened();
//    }
//
//    @Test
//    public void loginAsUserTest() {
//        shouldBeLoggedOut();
//        loginForm.shouldBeOpened();
//        loginForm.loginAs(DEFAULT_USER);
//        homePage.checkOpened();
//    }
//
//    @Test
//    public void plainLoginTest() {
//        shouldBeLoggedOut();
//        loginForm.shouldBeOpened();
//        loginForm.fill(DEFAULT_USER);
//        loginForm.login();
//        homePage.checkOpened();
//    }

    @Test
    public void fillContactFormTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.submit("Roman");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitEntityToContactFormTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.submit(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.submit("Roman", "custom");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void plainSubmitTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.submit();
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void verifyMethodPositiveTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(DEFAULT_CONTACT);
        List<String> verified = main.contactForm.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 0);
    }

    @Test
    public void verifyMethodNegativeTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = main.contactForm.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 1);
        assertTrue(verified.get(0).contains("Roman"));
    }

    @Test
    public void onlyMandatoryOptionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.onlyMandatory().fill(DEFAULT_CONTACT);
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactForm.getFilter(), ALL);
    }

    @Test
    public void onlyOptionalOptionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.onlyOptional().fill(DEFAULT_CONTACT);
        main.contactForm.check(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactForm.getFilter(), ALL);
    }

    private void checkContactFormSubmitted() {
        lastLogEntry.assertThat()
            .text(containsString("submit:button clicked"));
    }
}
