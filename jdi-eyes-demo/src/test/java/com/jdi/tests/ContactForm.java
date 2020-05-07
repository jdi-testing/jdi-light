package com.jdi.tests;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdi.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdi.states.State.*;
import static com.jdi.test.data.DefaultDataProvider.*;
import static jdisite.enums.MenuOptions.ContactForm;
import static jdisite.pages.ContactPage.*;
import static jdisite.pages.JDISite.*;

public class ContactForm extends TestsInit {
    @BeforeMethod
    public void before() {
        loggedIn();
        leftMenu.select(ContactForm);
    }

    @Test
    public void submitContactDataTest() {
        contactPage.checkOpened();
        contactForm.submit(FULL_CONTACT);
        contactForm.check(FULL_CONTACT);
    }
    @Test
    public void submitContactSimpleDataTest() {
        contactPage.checkOpened();
        contactForm.submit(SIMPLE_CONTACT);
        contactForm.check(SIMPLE_CONTACT);
    }

    @Test
    public void submitContactFormSimpleTest() {
        contactPage.checkOpened();
        contactForm.submit(FULL_CONTACT);
        contactForm.check(FULL_CONTACT);
    }
}
