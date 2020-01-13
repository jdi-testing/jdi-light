package io.github.epam.example.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @BeforeMethod
    public void before() {
        shouldContactPageBeOpenedAndRefreshed();
    }

    @Test
    public void fillContactFormTest() {
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormCustomTest() {
        main.contactFormCustom.submit("Roman");
        main.contactFormCustom.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        checkContactFormCustomSubmitted();
    }

    @Test
    public void submitEntityToContactFormCustomTest() {
        main.contactFormCustom.submit(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormCustomSubmitted();
    }

    @Test
    public void submitTextToContactFormCustomUsingCustomButtonTest() {
        main.contactFormCustom.submit("Roman", "custom");
        main.contactFormCustom.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void plainSubmitTest() {
        main.contactFormCustom.fill(DEFAULT_CONTACT);
        main.contactFormCustom.submit();
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormCustomSubmitted();
    }

    @Test
    public void onlyMandatoryOptionTest() {
        main.contactFormCustom.onlyMandatory().fill(DEFAULT_CONTACT);
        main.contactFormCustom.onlyMandatory().check(DEFAULT_CONTACT);
        main.contactFormCustom.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void onlyOptionalOptionTest() {
        main.contactForm.onlyOptional().fill(DEFAULT_CONTACT);
        main.contactFormCustom.onlyOptional().check(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void verifyMethodPositiveTest() {
        main.contactFormCustom.fill(DEFAULT_CONTACT);
        List<String> verified = main.contactFormCustom.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 0);
    }

    @Test
    public void verifyMethodNegativeTest() {
        main.contactFormCustom.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = main.contactFormCustom.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 1);
        assertTrue(verified.get(0).contains("Roman"));
    }

    private void checkContactFormCustomSubmitted() {
        lastLogEntry.assertThat()
                .text(containsString("submit:button clicked"));
    }
}
