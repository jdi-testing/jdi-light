package io.github.epam.example.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.entities.Users.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.Users.DEFAULT_CONTACT;
import static io.github.com.entities.Users.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.epam.html.tests.site.steps.States.shouldContactPageBeOpenedAndRefreshed;
import static org.hamcrest.Matchers.containsString;

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
    public void submitEntityToContactFormCustomTest() {
        main.contactFormCustom.submit(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormCustomSubmitted();
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
    public void submitTextToContactFormCustomTest() {
        main.contactFormCustom.submit("Roman");
        main.contactFormCustom.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        checkContactFormCustomSubmitted();
    }

    private void checkContactFormCustomSubmitted() {
        lastLogEntry.assertThat()
                .text(containsString("submit:button clicked"));
    }
}
