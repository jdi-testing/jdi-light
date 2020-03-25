package io.github.epam.html.tests.elements.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.common.FormFilters.*;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static io.github.com.StaticSite.*;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.ContactFormPage.*;
import static io.github.com.pages.LogSidebar.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class FormContactsTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
    }


    @Test
    public void fillContactFormTest() {
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormTest() {
        main.contactForm.submit("Roman");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitEntityToContactFormTest() {
        main.contactForm.submit(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        main.contactForm.submit("Roman", "custom");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormUsingNonExistentButtonTest() {
        main.contactFormCustom.submit("Roman", "nonExistent");
    }

    @Test
    public void submitEntityToContactFormUsingCustomButtonTest() {
        main.contactForm.submit(DEFAULT_CONTACT, "custom");
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitEntityToContactFormUsingNonExistentButtonTest() {
        main.contactFormCustom.submit(DEFAULT_CONTACT, "nonExistent");
    }

    @Test
    public void plainSubmitTest() {
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.submit();
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void pressButtonTest() {
        main.contactFormCustom.fill(DEFAULT_CONTACT);
        main.contactFormCustom.pressButton("custom");
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void verifyMethodPositiveTest() {
        main.contactForm.fill(DEFAULT_CONTACT);
        List<String> verified = main.contactForm.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 0);
    }

    @Test
    public void verifyMethodNegativeTest() {
        main.contactForm.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = main.contactForm.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 1);
        assertTrue(verified.get(0).contains("Roman"));
    }

    @Test
    public void checkMethodPositiveTest() {
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
        assertEquals(main.contactForm.verify(DEFAULT_CONTACT).size(), 0);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void checkMethodNegativeTest() {
        main.contactForm.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        TIMEOUTS.element.set(1);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void sendMethodTest() {
        main.contactFormCustom.fill(DEFAULT_CONTACT);
        main.contactFormCustom.send();
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void sendEntityMethodTest() {
        main.contactFormCustom.send(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void addEntityMethodTest() {
        main.contactFormCustom.add(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void publishMethodTest() {
        main.contactFormCustom.publish(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void saveMethodTest() {
        main.contactFormCustom.save(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void updateMethodTest() {
        main.contactFormCustom.update(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void cancelMethodTest() {
        main.contactFormCustom.cancel(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void closeMethodTest() {
        main.contactFormCustom.close(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void backMethodTest() {
        main.contactFormCustom.back(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void selectMethodTest() {
        main.contactFormCustom.select(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void nextMethodTest() {
        main.contactFormCustom.next(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void searchMethodTest() {
        main.contactFormCustom.search(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void onlyMandatoryOptionTest() {
        main.contactFormCustom.onlyMandatory().fill(DEFAULT_CONTACT);
        main.contactFormCustom.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactFormCustom.getFilter(), ALL);
    }

    @Test
    public void onlyOptionalOptionTest() {
        main.contactFormCustom.onlyOptional().fill(DEFAULT_CONTACT);
        main.contactFormCustom.check(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactFormCustom.getFilter(), ALL);
    }

    @Test
    public void overriddenFillActionTest() {
        main.contactFormCustomFill.fill(DEFAULT_CONTACT);
        main.contactFormCustomFill.check(UPPER_CASE_NAME_CONTACT);
    }

    @Test
    public void uiFormTest() {
        main.contactFormUI.submit(DEFAULT_CONTACT);
        main.contactFormUI.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void overriddenGetActionTest() {
        main.contactFormCustomGet.fill(DEFAULT_CONTACT);
        main.contactFormCustomGet.check(LOWER_CASE_NAME_CONTACT);
    }

    private void checkContactFormSubmitted() {
        lastLogEntry.assertThat()
                .text(containsString("submit:button clicked"));
    }
}
