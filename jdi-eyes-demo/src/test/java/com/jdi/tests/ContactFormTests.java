package com.jdi.tests;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdi.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdi.states.State.loggedIn;
import static com.jdi.test.data.DefaultDataProvider.FULL_CONTACT;
import static com.jdi.test.data.DefaultDataProvider.SIMPLE_CONTACT;
import static jdisite.enums.MenuOptions.ContactForm;
import static jdisite.pages.ContactPage.contactForm;
import static jdisite.pages.JDISite.contactPage;
import static jdisite.pages.JDISite.leftMenu;

public class ContactFormTests extends TestsInit {
    @BeforeMethod
    public void before() {
        loggedIn();
        leftMenu.select(ContactForm);
    }

    @Test
    public void submitContactFormFullDataTest() {
        contactPage.checkOpened();
        contactForm.submit(FULL_CONTACT);
        contactForm.check(FULL_CONTACT);
    }

    @Test
    public void submitContactFormSimpleDataTest() {
        contactPage.checkOpened();
        contactForm.submit(SIMPLE_CONTACT);
        contactForm.check(SIMPLE_CONTACT);
    }
}
