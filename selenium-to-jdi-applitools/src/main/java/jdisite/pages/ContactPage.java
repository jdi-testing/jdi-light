package jdisite.pages;

import jdisite.sections.ContactForm;
import jdisite.sections.ShortContactForm;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static jdisite.utils.DriverUtils.DRIVER;
import static org.testng.Assert.assertEquals;

public class ContactPage {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/contacts.html";
    public static final String TITLE = "Contact Form";
    public ContactForm contactForm = initElements(DRIVER, ContactForm.class);

    public static void CheckContactPageOpened() {
        assertEquals(DRIVER.getCurrentUrl(), ContactPage.URL);
        assertEquals(DRIVER.getTitle(), ContactPage.TITLE);
    }
    public ShortContactForm sContactForm = initElements(DRIVER, ShortContactForm.class);
}
